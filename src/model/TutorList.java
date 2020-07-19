package model;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TutorList extends User{
	private ArrayList<Tutors> tutors = new ArrayList<>();
	
	public TutorList() {
		
	}
	
    public void addTutor(int tutor_id, String name, String surname, String password) throws FileNotFoundException {
    	//add new tutor
    	tutors.add(new Tutors(tutor_id, name, password)); 
        
        //write tutors from arraylist to txt file
        PrintWriter txt = new PrintWriter("tutor.txt");
        for (int y = 0; y <tutors.size(); y++){
            int index = y+1;
            txt.println("Tutor " + index);
            txt.println("ID: " + tutors.get(y).getId());
            txt.println("Name: " + tutors.get(y).getName());
            txt.println("Password: " + tutors.get(y).getPassword());
            txt.println("--------------------");
            txt.flush();
        } 
        txt.close();
    }
	
    //check if there is a tutor with given id and return its index
    public int getIndex(int id) {
        for (int i = 0; i < tutors.size(); i++) {
            if (tutors.get(i).getId() == id) {
                return i;
            }
        }
        return super.getIndex();
    } 
    
    public String getPassword (int index) {
        return tutors.get(index).getPassword();
    }
}
