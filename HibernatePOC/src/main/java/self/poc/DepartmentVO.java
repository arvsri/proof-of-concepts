package self.poc;

import self.poc.entities.Department;
import self.poc.entities.Employee;

public class DepartmentVO {

	private String name;

	private String location;

	private Employee employee;

	public DepartmentVO() {

	}

	public DepartmentVO(String name, String location, Employee employee) {
		this.name = name;
		this.location = location;
		this.employee = employee;
	}

	public DepartmentVO(Department dept, Employee employee) {
		this.name = dept.getName();
		this.location = dept.getLocation();
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public Employee getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		return "DepartmentVO [name=" + name + ", location=" + location
				+ ", employees=" + employee + "]";
	}

}
