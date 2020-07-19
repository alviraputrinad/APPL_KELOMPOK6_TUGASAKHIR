
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Tutors extends User {
    private String password;
    

    public Tutors(){
    }

    public Tutors(int id, String name, String password) throws FileNotFoundException {
        super(id, name);
        this.password = password;
    }

    public String getName() {
        return super.getName();
    }

    public void validatePassword(String pass) {
    	
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}