

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.*;
import view.*;

public class Menu {
	
    private static Scanner in = new Scanner(System.in);
    private static Tutors t;
    private static Students s;
    private static User u;
    private static int qId = 1;
    private static int TestTaken =0;
    private static StudentList studentList = new StudentList();
    private static TutorList tutorList = new TutorList();

    private static Quiz quiz = new Quiz();
    private static QuizList quizList = new QuizList();
    private static PointRecapitulation pointRecap = new PointRecapitulation();



    
    public static void appMenu() throws FileNotFoundException {
        //t.addTutor(1, "default", "tutor", "00000000"); //default tutor for starting the program
        //q.addQuestion(0, "Default question", "yes", 0); //default question to handle index out of bound errors

        while (true) {
            System.out.println("Are you a student or a tutor?");
            String whoRU = in.nextLine();
            if (whoRU.toLowerCase().equals("tutor")) {
                tutorCredentials();
                break;
            }else if(whoRU.toLowerCase().equals("student")) {
                studentCredentials();
                break;
            } else{
                System.out.println("Please enter either tutor or student!");
            }
        }
    }

    public static void studentCredentials() throws  FileNotFoundException{
        int id = 0;
        Students student = studentList.getIndex(id);
        System.out.println("Please enter your ID:");
        while(true) {
            boolean isIdInt = in.hasNextInt();
            id = in.nextInt();
            if(isIdInt){
                if(student == null){
                    System.out.println("There is no student with ID: "+id);
                    System.out.println("ID: ");
                    in.nextLine();
                    continue;
                }
                System.out.println("Welcome, " + student.getName() + "!");
                break;
            }else{
                System.out.println("Please enter your ID!");
                in.nextLine();
            }
        }
        
        studentMenu(id);//student log in
    }
    
    public static void studentMenu(int studentId) throws FileNotFoundException {
    	ArrayList<Integer> wrongAnswer = new ArrayList<>();
        while (true){
        	Display.studentMenu();
            boolean isInt = in.hasNextInt();
            int option = in.nextInt();
            if (isInt){
                switch (option){
                    case Constant.RUNTEST :
                    	System.out.println("Enter test code: ");
                    	String testCode = in.next();
                        wrongAnswer = runTest(studentId, testCode);
                        break;
                    case Constant.RESULT:
                    	Display.testResult(wrongAnswer, studentId, quiz);
                        break;
                    case Constant.STUDENT_LOGOUT:
                        System.out.println("Logging out .....");
                        in.nextLine();
                        appMenu();
                        break;
                    default:
                        System.out.println("Please enter 1-4!");
                        continue;
                }
            }else
                System.out.println("Please enter a number!");
        } //student menu
    }

    public static void tutorCredentials() throws FileNotFoundException {
        System.out.println("Enter your ID: ");
        int id = 0;
        while(true){
            boolean isInt = in.hasNextInt();
            id = in.nextInt();
            if(isInt){
                if(t.getId() != id){
                    System.out.println("There is no tutor with ID: "+ id);
                    System.out.println("ID: ");
                    in.nextLine();
                    continue;
                }
                System.out.println("Enter your password;");
                String password = in.next();
                if(password.equals(t.getPassword()))
                    System.out.println("Welcome, "+ t.getName() );
                else {
                    System.out.println("Incorrect password! Try again!");
                    in.nextLine();
                    password = in.next();
                }break;
            }else{
                System.out.println("Please enter your ID!");
                in.nextLine();
            }
        }
        tutorMenu();//tutor log in
    }
    public static void createQuiz(Quiz quiz) throws FileNotFoundException {
    	String qText = null, qAnswer, qTAnswer;
    	HashMap <String, String> qListAnswer = new HashMap<String, String>();
    	Questions qQuiz;
    	switch(quiz.getType()) {
    		case 1 :
    			qTAnswer = "";
    			qText = "";
    			for(int i = 0; i < quiz.getNQuiz(); i++) {
    				 System.out.println("No " + i+1);
    				 System.out.println("Question : ");
    				 qText = in.nextLine();
    				 System.out.println("Please enter multiple option...");
    				 for(int j = 0; j < 4; j++) {
    					 System.out.println("Option #"+ j+1 +":" );
    					 qAnswer = in.nextLine();
    					 qListAnswer.put(Integer.toString(j+1), qAnswer);
    				 }
    				 System.out.println("The right option is : (1/2/3/4)");
    				 qTAnswer = in.nextLine();
    				 qQuiz = new Questions(qText, qTAnswer, qListAnswer);
    				 quiz.addQuestion(qQuiz);	 
    				 break;
    			}
    		case 2 : 
    			for(int i = 0; i < quiz.getNQuiz(); i++) {
    				 System.out.println("No " + i+1);
    				 System.out.println("Question : ");
    				 qText = in.nextLine();
    				 qListAnswer.put("","TRUE");
    				 qListAnswer.put("","FALSE");
    			}
    			System.out.println("The right option is : (TRUE/FALSE)");
				qTAnswer = in.nextLine();
				qQuiz = new Questions(qText, qTAnswer, qListAnswer);
				quiz.addQuestion(qQuiz);
				break;
    	}
    	
    }
    public static void tutorMenu() throws FileNotFoundException {
        while (true){
        	Display.tutorMenu();
            boolean isInt = in.hasNextInt();
            int option = in.nextInt();
            if (isInt){
                switch (option){
                    case Constant.ADD_STUDENT:
                        String studentName;
                        int studentId;
                        System.out.println("Name: ");
                        studentName = in.next();
                        while (true) {
                            System.out.println("Student ID: ");
                            studentId = in.nextInt();
                            if (s.getId() == studentId) {
                                studentList.addStudent(studentId, studentName);
                                break;
                            } else
                                System.out.println("This ID is already registered!");
                        }
                        break;
                    case Constant.ADD_TUTOR:
                        
                        String ttName, ttSurname, password;
                        int ttId;
                        System.out.println("Name: ");
                        ttName = in.next();
                        System.out.println("Surname: ");
                        ttSurname = in.next();
                        while (true){
                            System.out.println("Password: ");
                            password = in.next();
                            validatePassword(password);
                            if (t.getPassword()!=null)
                                break;
                        }
                        while (true) {
                            System.out.println("Tutor ID: ");
                            ttId = in.nextInt();
                            if(t.getId()==-1) {
                            	tutorList.addTutor(ttId,ttName,ttSurname,password);
                                break;
                            } else
                                System.out.println("This ID is already registered!");
                        }
                        break;
                    case Constant.CREATE_TEST:
                        String qTitle, qCode,  qId;
                        int nQuiz, qType, qTime;
                        double qPoint;
                        System.out.println("Enter Title");
                        qTitle = in.next();
                        System.out.println("Enter Id: ");
                        qId = in.next();
                        System.out.println("Enter Code: ");
                        qCode = in.next();
                        System.out.println("1. Multiple choice\n" + 
                        					"2. True/False\n" +
                        					"Type Test :"
                        					);
                        qType = in.nextInt();
                        System.out.println("how many questions will be created?");
                        nQuiz = in.nextInt();
                        System.out.println("how long it takes? (s)");
                        qTime = in.nextInt();
                        System.out.println("point per question : ");
                        qPoint = in.nextInt();
                        Quiz quiz = new Quiz(qId, qCode, qType, qTime, qTitle, qPoint, nQuiz);
                        createQuiz(quiz);
                        quizList.addQuiz(quiz);
                        break;
                    case Constant.DISPLAY_STUDENT:
                        int enterId;
                        
                        System.out.println(studentList.getAllStudent());
                        break;
                    case Constant.DISPLAY_QUESTION:
                        //q.getQuestion();
                        break;
                    case Constant.DISPLAY_BEST_WORST_STUDENT:
                    	System.out.println("Enter Quiz Id: ");
                    	String idQuiz = in.next();
                    	quizList.showBestWorstPoint(idQuiz);
                        break;
                    case Constant.REMOVE_STUDENT:
                        int removeId;
                        System.out.println("Student ID: ");
                        removeId = in.nextInt();
                        studentList.removeStudent(removeId);
                        break;
                    case Constant.LOGOUT:
                        System.out.println("Logging out .....");
                        in.nextLine();
                        appMenu();
                        break;
                    default:
                        System.out.println("Please enter 1-7!");
                        continue;
                }
            }else
                System.out.println("Please enter a number!");
        } // tutor menu

    }
    
    public static ArrayList<Integer> runTest(int idStudent, String code){
    	ArrayList<Integer> wrongAnswer = new ArrayList<>();
        String answer;
        int points = 0;
        int times = 0;
        if(quizList.getQuiz().isEmpty()) {
        	System.out.println("There are no quiz");
        }
        else {
        	if(quizList.isQuizExist(code)) {
        		quiz = quizList.getQuizbyCode(code);
        		/*
        		 * get type quiz
        		 * print question by type
        		 */
        		switch(quiz.getType()) {
        			case Constant.PILIHAN_GANDA:
        				break;
        			case Constant.YESorNO:
        				for (int i = 0; i < quiz.getAllQuestion().size(); i++){
                    		System.out.println(i + 1 + ". " + quiz.getAllQuestion().get(i) + "?");
                    		answer = in.nextLine();
                    		while (true){
                    			if (!(answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("no"))) {
                    				System.out.println("Please enter yes or no! ");
                    				answer = in.nextLine();
                    			} else break;
                    		}
                    		if(validateAnswer(Constant.YESorNO, i+1, answer) == 0) {
                    			wrongAnswer.add(i+1);
                    		} else {
                    			points = points + validateAnswer(Constant.YESorNO, i+1, answer);
                    		}
        				}
        				break;
        		}
        		
        		quiz.addRecap(idStudent, points);
        	}else {
        		System.out.println("There are no quiz");
        	}
        } // run test
        
        return wrongAnswer;
    }
    
    /*
     * validating answer
     */
    public static int validateAnswer(int type, int id_question, String answer) {
    	int point = 0;
    	Questions question = quiz.getQuestion(id_question);
    	
    	if(answer.toLowerCase().equals(question.getQuestionAnswer())) {
			return question.getQuestionPoint();
		}
    	
    	return point;
    }
    
 // check password's conditions
  public static void validatePassword(String password) {
      boolean passContainsNr = false;
      for (int i = 0; i < 10; i++) {
          if (password.contains(Integer.toString(i))) {
              passContainsNr = true;
          }
      }
      if (passContainsNr && password.length() > 7) {
          t.setPassword(password);
          System.out.println("Successfully set password.");
      } else if (password.length() > 7 && !passContainsNr) {
          System.out.println("Password must include a number!");
      } else if (passContainsNr && password.length() < 8) {
          System.out.println("Password must be at least 8 character long.");
      } else {
          System.out.println("Password must have more than 8 characters. It must include a number!");
      }
  }
    
}