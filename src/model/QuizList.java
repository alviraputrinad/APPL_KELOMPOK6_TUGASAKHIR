package model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuizList {
	private ArrayList<Quiz> quiz = new ArrayList<>();
	private StudentList studentList = new StudentList();
	private Students student = new Students();
	private Quiz q = new Quiz();
	private PointRecapitulation pointRecapitulation = new PointRecapitulation();
	

	public void showBestWorstPoint(String codeQuiz) {
		if(isQuizExist(codeQuiz)) {
			q=getQuizbyCode(codeQuiz);
			ArrayList<PointRecapitulation> pointRecap = q.getPointRecap();
			Collections.sort(pointRecap, Comparator.comparing(PointRecapitulation::getPoint));
			showBestPoint(pointRecap);
			showWorstPoint(pointRecap);
			pointRecap.forEach(System.out::println);
		}else {
			System.out.println("Quiz dengan code " +codeQuiz +" tidak ditemukan");
		}
	}

	public ArrayList<Quiz> getQuiz() {
		return quiz;
	}
	
	public void addQuiz(Quiz quiz) {
		this.quiz.add(quiz);
	}

	public void showBestPoint(ArrayList<PointRecapitulation> pointRecap) {
		pointRecapitulation = pointRecap.get(pointRecap.size() -1);
		student = studentList.getIndex(pointRecapitulation.getIdStudent());
		System.out.println("Best Point " +student.getName()+" dengan point " +pointRecapitulation.getPoint());
	}
	
	public void showWorstPoint(ArrayList<PointRecapitulation> pointRecap) {
		pointRecapitulation = pointRecap.get(0);
		student = studentList.getIndex(pointRecapitulation.getIdStudent());
		System.out.println("Worst Point " +student.getName()+" dengan point " +pointRecapitulation.getPoint());
	}
	
	public Quiz getQuizbyCode(String codeQuiz){
		for (Quiz q : quiz) {
	        if (q.getCode().equals(codeQuiz)) {
	        	return q;
	        }
	    }
		return null;
	}
	
	public boolean isQuizExist(String codeQuiz){
		for (Quiz q : quiz) {
	        if (q.getCode().equals(codeQuiz)) {
	        	return true;
	        }
	    }
		return false;
	}
	
}