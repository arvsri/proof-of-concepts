package self.poc.josql;

import java.util.Date;


public class Employee {

    private int id;

    private String name;
    private String gender;

    private Date dateOfJoining;
    private String employmentType;
    private Department department;

    public Employee(int id, String name, String gender, Date dateOfJoining, String employmentType,Department d) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;
        this.employmentType = employmentType;
        this.department = d;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getGender() {
        return gender;
    }


    public Date getDateOfJoining() {
        return dateOfJoining;
    }


    public String getEmploymentType() {
        return employmentType;
    }


    public Department getDepartment() {
        return department;
    }


}
