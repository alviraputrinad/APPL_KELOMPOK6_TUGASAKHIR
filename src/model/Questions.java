package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Questions {
    private int questionId=0;
    private String questionText;
    private String questionAnswer;
    private int questionPoint;
    private HashMap<String, String> listAnswer;
    public Questions(){}

    public Questions( String questionText, String questionAnswer, HashMap<String, String> listAnswer) throws FileNotFoundException {
        this.questionId = questionId+1;
        questionId =  questionId+1;
        this.listAnswer = listAnswer;
        this.questionText = questionText;
    }

    public void addQuestionToFile() throws FileNotFoundException {
        PrintWriter txt = new PrintWriter("question.txt");
            txt.print(this.getquestionId()+ ". ");
            txt.println(this.getQuestionText() + "?");
            for (String i : this.listAnswer.keySet()) {
            	txt.println(i+". "+ this.listAnswer.get(i));
            }
            txt.println("Answer: "+ this.getQuestionAnswer());
            txt.println("--------------------");
            txt.flush();
            txt.close();
        } 
       

    public String getQuestionText() {
        return this.questionText;
    }
    
    public int getquestionId(){
        return this.questionId;
    }

    public HashMap<String, String> getListQuestion() {
    	return this.listAnswer;
    }
    public String getQuestionAnswer(){
        return questionAnswer;
    }

	public int getQuestionPoint() {
		return questionPoint;
	}

	public void setQuestionPoint(int questionPoint) {
		this.questionPoint = questionPoint;
	}
    
    

}