

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	static final int PILIHAN_GANDA=1;
	static final int ESSAY=2;
	static final int YESorNO=3;
	
    private static Scanner in = new Scanner(System.in);
    private static Tutors t;
    private static Students s;
    private static User u;
    private static int qId = 1;
    private static int TestTaken =0;
    private static StudentList studentList = new StudentList();

    private static Quiz quiz = new Quiz();
    private static QuizList quizList = new QuizList();
    private static PointRecapitulation pointRecap = new PointRecapitulation();
    private static UserList uList = new UserList();



    
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
    
    public static void studentMenu(int studentId) {
    	ArrayList<String> wrongAnswer = new ArrayList<>();
        while (true){
            System.out.println("Please choose one of the below option: (Option Number)" +
                    "\n1. Run a test" +
                    "\n2. Display total points " +
                    "\n3. Log out.");
            boolean isInt = in.hasNextInt();
            int option = in.nextInt();
            if (isInt){
                switch (option){
                    case 1 :
                    	System.out.println("Enter test code: ");
                    	String testCode = in.next();
                        wrongAnswer = runTest(studentId, testCode);
                        break;
                    case 2:
                        //bikin method displayrightasnwer, buat nge print jawaban bener buat setiap quest.id yg salah
                    	//dari wronganswer
                        break;
                    case 3:
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
    public static void tutorMenu() {
        while (true){
            System.out.println("Please choose one of the below option: (Option Number)" +
                    "\n1.Add a new student.\n2.Add a new tutor\n3.Create Test" +
                    "\n4.Display All Data Student\n5.Display all questions" +
                    "\n6.Display best and worst student\n7.Remove a student\n" +
                    "\n8.Log out.");
            boolean isInt = in.hasNextInt();
            int option = in.nextInt();
            if (isInt){
                switch (option){
                    case 1:
                        int stId,year,month,day;
                        String stName, stSurname;
                        System.out.println("Name: ");
                        stName = in.next();
                        System.out.println("Surname: ");
                        stSurname = in.next();
                        while (true) {
                            System.out.println("Student ID: ");
                            stId = in.nextInt();
                            if (s.getId() == stId) {
                                uList.addStudent();
                                break;
                            } else
                                System.out.println("This ID is already registered!");
                        }
                        break;
                    case 2:
                        
                        String ttName, ttSurname, password, ttId;
                        System.out.println("Name: ");
                        ttName = in.next();
                        System.out.println("Surname: ");
                        ttSurname = in.next();
                        while (true){
                            System.out.println("Password: ");
                            password = in.next();
                            t.validatePassword(password);
                            if (t.getPassword()!=null)
                                break;
                        }
                        while (true) {
                            System.out.println("Tutor ID: ");
                            ttId = in.next();
                            if(t.getId()==-1) {
                            	uList.addTutor(ttId,ttName,ttSurname,password);
                                break;
                            } else
                                System.out.println("This ID is already registered!");
                        }
                        break;
                    case 3:
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
                    case 4:
                        int enterId;
                        
                        System.out.println(uList.getAllStudent());
                        break;
                    case 5:
                        //q.getQuestion();
                        break;
                    case 6:
                    	quizList.showBestWorstPoint(qId);
                        break;
                    case 7:
                        String removeId;
                        System.out.println("Student ID: ");
                        removeId = in.next();
                        uList.removeStudent(removeId);
                        break;
                    case 8:
                        //s.getFailedStudent();
                        break;
                    case 9:
                        System.out.println("Test is taken " + TestTaken + " times.");
                        break;
                    case 10:
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
    
    public static ArrayList<String> runTest(int idStudent, String code){
    	ArrayList<String> wrongAnswer = new ArrayList<>();
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
        			case PILIHAN_GANDA:
        				break;
        			case ESSAY:
        				break;
        			case YESorNO:
        				for (int i = 0; i < quiz.getAllQuestion().size(); i++){
                    		System.out.println(i + 1 + ". " + quiz.getAllQuestion().get(i) + "?");
                    		answer = in.nextLine();
                    		while (true){
                    			if (!(answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("no"))) {
                    				System.out.println("Please enter yes or no! ");
                    				answer = in.nextLine();
                    			} else break;
                    		}
                    		/*
                    		 * cek jawaban (ngambil jawabannya gimana?)
                    		 * total poin
                    		 */
                    		//disini manggil method validate answer, kalo return nya 0, masukin question id ke arraylist wrongAnswer
                    		//if ((answer.toLowerCase().equals("yes") && q.getQuestionsArray().get(i).isquestionAnswer())||(answer.toLowerCase().equals("no") && !q.getQuestionsArray().get(i).isquestionAnswer()))
                            //points += q.getQuestionsArray().get(i).getquestionPoints();
        				}
        				break;
        		}
            		/*
            		 * set total point
            		 */
        			pointRecap= new PointRecapitulation(idStudent, points);
        			//ini butuh ga?
                	/*if (quiz.getAllQuestion().size()!=0 && s.getStudentsArray().get(index).getTotalPointsFromTests()==0){
                		System.out.println("Sorry you failed.");
                		s.getStudentsArray().get(index).setFailed(true);
                	}*/
        	}else {
        		System.out.println("There are no quiz");
        	}
        } // run test
        
        return wrongAnswer;
    }
    
    /*
     * validating answer
     */
    public double validateAnswer(int type, String id_question, String answer) {
    	double point = 0;
    	switch(type) {
			case PILIHAN_GANDA:
				break;
			case ESSAY:
				break;
			case YESorNO:
				//nanti disini dicek apakah jawaban sama dengan jawaban yang disoal
				//kalo sama point = point + point dari question
    	}
    	return point;
    }

  //validasi password tutor
//  public void validatePassword(String password) {
//      boolean passContainsNr = false;
//      for (int i = 0; i < 10; i++) {
//          if (password.contains(Integer.toString(i))) {
//              passContainsNr = true;
//          }
//      }
//      if (passContainsNr && password.length() > 7) {
//          this.setPassword(password);
//          System.out.println("Successfully set password.");
//      } else if (password.length() > 7 && !passContainsNr) {
//          System.out.println("Password must include a number!");
//      } else if (passContainsNr && password.length() < 8) {
//          System.out.println("Password must be at least 8 character long.");
//      } else {
//          System.out.println("Password must have more than 8 characters. It must include a number!");
//      }
//  } // check password's conditions
    
    
    //murid nilai terbesar terkecil
//  public void displayTPForLoggedInSt(int id) {
//  int index = getIndex(id);
//  System.out.println("Your total points are: "+students.get(index).getTotalPointsFromTests());
//} // show total points for logged in student

//public void displayBestWorstStudent() {
//  if (students.size()==0)
//      System.out.println("There are no students registered");
//  else{
//      int min = students.get(0).getTotalPointsFromTests();
//      int max = students.get(0).getTotalPointsFromTests();
//
//      int indexMax = 0;
//      int indexMin = 0;
//
//      for (int i = 0; i < students.size(); i++) {
//          if (max < students.get(i).getTotalPointsFromTests()) {
//              max = students.get(i).getTotalPointsFromTests();
//              indexMax = i;
//          }
//          if (min > students.get(i).getTotalPointsFromTests()) {
//              min = students.get(i).getTotalPointsFromTests();
//              indexMin = i;
//          }
//      }
//      System.out.println("Best student is " + students.get(indexMax).getName() + " " + students.get(indexMax).getSurname()
//              + ": " + max + "points.\nWorst student is " + students.get(indexMin).getName() + " " + students.get(indexMin).getSurname()
//              + ": " + min + "points.");
//  }
//}// display student with highest/lowest points
}