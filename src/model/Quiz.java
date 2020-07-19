package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Quiz {
	private String idQuiz;
    private String code;
    private int type;
    private int time;
    private String title;
    private double questionPoint;
    
    private List<Questions> questionList = new ArrayList<>();
    private ArrayList<PointRecapitulation> pointRecap = new ArrayList<>();
    
    public Quiz() {}
    
    public Quiz(String idQuiz, String code, int type, int time, String title, double questionPoint,
    			List<Questions> questionList) {
	    this.setIdQuiz(idQuiz);
	    this.setCode(code);
	    this.setType(type);
	    this.setTime(time);
	    this.setTitle(title);
	    this.setQuestionPoint(questionPoint);	
	    this.questionList = questionList;
	}

    public void bestWorstPoint(){}


	public ArrayList<PointRecapitulation> getPointRecap() {
		return pointRecap;
	}
    
	public List<Questions> gettingQuestionList() {
		return questionList;
	}
	
	public List<String> getAllQuestion() {
		List<String> question = new ArrayList<>();
		for(int i = 0; i < gettingQuestionList().size(); i++){
			question.add(gettingQuestionList().get(i).getQuestionText());
		}
		return question;
	}
	
	public String getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(String idQuiz) {
		this.idQuiz = idQuiz;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getQuestionPoint() {
		return questionPoint;
	}

	public void setQuestionPoint(double questionPoint) {
		this.questionPoint = questionPoint;
	}
	
	public Questions getQuestion(int questionId) {
		for(Questions question : questionList) {
			if(question.getquestionId() == questionId) {
				return question;
			}
		}
		return null;
	}
	
	public int getStudentPoint(int studentId) {
		for(PointRecapitulation recap : pointRecap) {
			if(recap.getIdStudent() == studentId) {
				return recap.getPoint();
			}
		}
		return 0;
	}
	
	public void addRecap(int studentId, int point) {
		PointRecapitulation recap = new PointRecapitulation(studentId, point);
		this.pointRecap.add(recap);
	}
	
}