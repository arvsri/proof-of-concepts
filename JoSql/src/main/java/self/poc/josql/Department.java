package self.poc.josql;

import java.util.ArrayList;
import java.util.List;


public class Department {
    
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private List<Employee> employees = new ArrayList<Employee>();

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public List<Employee> getEmployees() {
        return employees;
    }


}
