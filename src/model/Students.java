package model;

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

    public int getStudent_id() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }


}