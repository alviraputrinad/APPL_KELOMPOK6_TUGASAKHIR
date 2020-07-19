import java.io.IOException;
import java.util.ArrayList;

public class QuizList {
	private ArrayList<Quiz> quiz = new ArrayList<>();
	
	public void showBestWorstPoint(int idQuiz) {
		//showbestpoint:cari id student, kalo udh dapet, quiz[i].bestPoint()
	}

	public ArrayList<Quiz> getQuiz() {
		return quiz;
	}
	
	public void addQuiz(Quiz quiz) {
		this.quiz.add(quiz);
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