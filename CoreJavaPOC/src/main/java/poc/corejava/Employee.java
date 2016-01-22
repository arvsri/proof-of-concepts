package poc.corejava;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private String address;
	private double salary;
	private Date dateOfJoining;
	private Employee supervisor;
	
	public Employee(int id, String name, String address, double salary,
			Date dateOfJoining, Employee supervisor) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.supervisor = supervisor;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public double getSalary() {
		return salary;
	}


	public Date getDateOfJoining() {
		return dateOfJoining;
	}


	public Employee getSupervisor() {
		return supervisor;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	
	
}
