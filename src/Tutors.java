
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

    
//jangan disini
//    public void validatePassword(String password) {
//        boolean passContainsNr = false;
//        for (int i = 0; i < 10; i++) {
//            if (password.contains(Integer.toString(i))) {
//                passContainsNr = true;
//            }
//        }
//        if (passContainsNr && password.length() > 7) {
//            this.setPassword(password);
//            System.out.println("Successfully set password.");
//        } else if (password.length() > 7 && !passContainsNr) {
//            System.out.println("Password must include a number!");
//        } else if (passContainsNr && password.length() < 8) {
//            System.out.println("Password must be at least 8 character long.");
//        } else {
//            System.out.println("Password must have more than 8 characters. It must include a number!");
//        }
//    } // check password's conditions

    public String getName() {
        return super.getName();
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}