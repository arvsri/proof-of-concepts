package self.poc.entities;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	private int employeeId;
	private String name;
	private String address;
	private Date createdDate;

	private Department department;

	public Employee() {
	}

	public Employee(int employeeId, String name, String address,
			Date createdDate) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", address=" + address + ", createdDate=" + createdDate + "]";
	}
	
	

}
