package view;

import java.util.ArrayList;

import model.Questions;
import model.Quiz;

public class Display {
    public static void testResult(ArrayList<Integer> questionId, int studentId, Quiz quiz) {
    	System.out.println("----------Result----------");
    	System.out.println("point " + quiz.getStudentPoint(studentId));
    	//System.out.println("ranking " + quiz.getStudentPoint(studentId));
    	System.out.println("----------The Right Answer----------");
    	for(Integer id : questionId) {
    		Questions question = quiz.getQuestion(id);
    		System.out.println(id + "." + question.getQuestionAnswer());
    	}
    }
    
    public static void tutorMenu() {
    	System.out.println("Please choose one of the below option: (Option Number)" +
                "\n1.Add a new student." + 
    			"\n2.Add a new tutor." + 
                "\n3.Create Test" +
                "\n4.Display All Data Student." +
                "\n5.Display all questions" +
                "\n6.Display best and worst student " + 
                "\n7.Remove a student\n" +
                "\n8.Log out.");
    }
    
    public static void studentMenu() {
    	System.out.println("Please choose one of the below option: (Option Number)" +
                "\n1. Run a test" +
                "\n2. Display total points " +
                "\n3. Log out.");
    }
}
