package model;
import java.io.IOException;
import java.util.ArrayList;

public class QuizList {
	private ArrayList<Quiz> quiz = new ArrayList<>();
	
	public void showBestWorstPoint(String idQuiz) {
		Quiz selectedQuiz;
		for(Quiz vQuiz : quiz) {
			if(vQuiz.getIdQuiz() == idQuiz) {
				selectedQuiz = vQuiz;
				break;
			}
		}
		
	}

	public ArrayList<Quiz> getQuiz() {
		return quiz;
	}
	
	public Quiz getQuizbyCode(String code){
		for (Quiz q : quiz) {
	        if (q.getCode().equals(code)) {
	        	return q;
	        }
	    }
		return null;
	}
	
	public boolean isQuizExist(String code){
		for (Quiz q : quiz) {
	        if (q.getCode().equals(code)) {
	        	return true;
	        }
	    }
		return false;
	}
	
}