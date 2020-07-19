
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Nasty
 */
public class Students extends User {

    private ArrayList<String> test_history = new ArrayList<>();
    private ArrayList<Double> point_history = new ArrayList<>();

    public Students() {
    	
    }

    public Students(int id, String name) throws FileNotFoundException {
        super(id, name);
    }


//    public void displayTPForLoggedInSt(int id) {
//        int index = getIndex(id);
//        System.out.println("Your total points are: "+students.get(index).getTotalPointsFromTests());
//    } // show total points for logged in student

//    public void displayBestWorstStudent() {
//        if (students.size()==0)
//            System.out.println("There are no students registered");
//        else{
//            int min = students.get(0).getTotalPointsFromTests();
//            int max = students.get(0).getTotalPointsFromTests();
//
//            int indexMax = 0;
//            int indexMin = 0;
//
//            for (int i = 0; i < students.size(); i++) {
//                if (max < students.get(i).getTotalPointsFromTests()) {
//                    max = students.get(i).getTotalPointsFromTests();
//                    indexMax = i;
//                }
//                if (min > students.get(i).getTotalPointsFromTests()) {
//                    min = students.get(i).getTotalPointsFromTests();
//                    indexMin = i;
//                }
//            }
//            System.out.println("Best student is " + students.get(indexMax).getName() + " " + students.get(indexMax).getSurname()
//                    + ": " + max + "points.\nWorst student is " + students.get(indexMin).getName() + " " + students.get(indexMin).getSurname()
//                    + ": " + min + "points.");
//        }
//    }// display student with highest/lowest points


    public int getStudent_id() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }


}