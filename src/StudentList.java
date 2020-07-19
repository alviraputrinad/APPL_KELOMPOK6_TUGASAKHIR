import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentList extends User{
	
	private ArrayList<Students> students = new ArrayList<>();
	
	public StudentList() {
		
	}
	
    public void addStudent(int student_id, String name) throws FileNotFoundException {
        students.add(new Students(student_id, name)); //add new student
        PrintWriter txt = new PrintWriter("student.txt");
        for(int z = 0; z < students.size(); z++){
            int index = z + 1;
            txt.println("Student: " + index);
            txt.println("ID: " + students.get(z).getStudent_id());
            txt.println("Name: " + students.get(z).getName());
            txt.println("--------------------");
            txt.flush();
        } //write student from arraylist to txt file
        txt.close ();
    }
    
    public void removeStudent (int id){
        if(getIndex(id) != -1) {
        	students.remove(getIndex(id));
        } else {
        	System.out.println("There is no student with ID: " + id);
        }
    }
    
    public void displayStudent(int id) {
		int i = getIndex(id);
		if (i != -1) {
			System.out.println("Id: " + id + "\nName: " + students.get(i).getName());
		} else {
			System.out.println("There is no student with id: " + id);
		}    
	}
    
    public int getStudent_id() {
    	return super.getId();
    }
    
    public int getIndex(int id) {
    	for (int i = 0; i < students.size(); i++) {
        	if (students.get(i).getStudent_id() == id) {
            	return i;
        	}
    	}
    	return super.getIndex();
	}
}
