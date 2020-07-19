import java.util.ArrayList;
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
	
	public List<Questions> getAllQuestion() {
		List<Questions> question = new ArrayList<>();
		for(int i =0; i<gettingQuestionList().size(); i++){
			//question.add(gettingQuestionList().get(i).getquestion_text());
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
}