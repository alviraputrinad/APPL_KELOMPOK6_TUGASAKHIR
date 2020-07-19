import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quiz {
	private String idQuiz;
    private String code;
    private int type;
    private int time;
    private int nQuiz;
    private String title;
    private double questionPoint;
    
    private List<Questions> questionList;
    private ArrayList<PointRecapitulation> pointRecap = new ArrayList<>();
    
    public Quiz() {}
    
    public Quiz(String idQuiz, String code, int type, int time, String title, double questionPoint, int nQuiz) {
    this.setIdQuiz(idQuiz);
    this.setCode(code);
    this.setType(type);
    this.setTime(time);
    this.setTitle(title);
    this.setNQuiz(nQuiz);
    this.setQuestionPoint(questionPoint);	
    //this.questionList = questionList;
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
		for(int i =0; i<gettingQuestionList().size(); i++){
			question.add(gettingQuestionList().get(i).getQuestionText());
		}
		return question;
	}
	public void addQuestion(Questions quiz) {
		
		this.questionList.add(quiz);
	}
	
	public void setNQuiz(int nQuiz) {
		this.nQuiz = nQuiz;
	}
	public int getNQuiz() {
		return nQuiz;
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
}