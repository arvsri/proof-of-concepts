package poc.corejava;

import java.util.Calendar;
import java.util.Date;

public class EmployeeInstances {

	private int initId;
	private String initName;
	private String initAddress;
	private double initSalary;
	private Date initDateOfJoining;
	private Employee supervisior;

	public EmployeeInstances(){	
		this.initId = 1;
		this.initName = "Name";
		this.initAddress = "Address";
		this.initSalary = 1000;
		this.initDateOfJoining = new Date();
		this.supervisior = null;
	}
	
	public EmployeeInstances(int id, String name, String address, double salary,
			Date dateOfJoining, Employee supervisor){
		this.initId = id;
		this.initName = name;
		this.initAddress = address;
		this.initSalary = salary;
		this.initDateOfJoining = dateOfJoining;
		this.supervisior = supervisor;
	}

	
	public Employee instances(){
		return new Employee(initId + 0, initName+ 0, initAddress+ 0, initSalary + 0,new Date() , supervisior);
	}
	
	public Employee[] nInstances(int numOfEmployees){
		Calendar cal = Calendar.getInstance();
		if(this.initDateOfJoining != null){
			cal.setTime(initDateOfJoining);
		}
		Employee[] emps = new Employee[numOfEmployees];
		for(int i = 0; i < numOfEmployees; i++){
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + i);
			emps[i] = new Employee(initId + i, initName+ i, initAddress+ 1, initSalary + 1,cal.getTime() , supervisior);
		}
		return emps;
	}
	
}
