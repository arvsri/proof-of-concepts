package poc.corejava.lambda;

import java.util.ArrayList;
import java.util.List;

import poc.corejava.lambda.Employee.sex;

/**
 * From a list of employees, selects a few and get their email address and send them an email
 * 
 */
public class OfficeSupervisor {
	
	final List<Employee> employees;
	
	public OfficeSupervisor(List<Employee> employees){
		this.employees = employees;
	}
	
	public void performOfficeWork(){
		echo( () ->System.out.println("\n printing email address of employees living in gurgaon \n"));
		selectAndOperate(employees,x -> x.getAddress().contains("Gurgaon"), y -> System.out.println(y.getEmail()) );
		
		
		echo( () ->System.out.println("\n printing email address of female employees\n"));
		selectAndOperate(employees,x -> x.getSexx() == sex.female, y -> System.out.println(y.getEmail()) );
		
		echo( () -> System.out.println("\n printing email address of male employees\n"));
		employees.stream().filter(x -> x.getSexx() == sex.male).map(y -> y.getEmail()).forEach( z -> System.out.println(z));
	}
	

	private <T> void selectAndOperate(List<T> emps, Predicate<T> p, Operate<T> o){
		for(T e : emps){
			if(p.evaluate(e)){
				o.perform(e);
			}
		}
	}
	
	private void echo(Alert o){
		o.perform();
	}

	
	public static void main(String... args){
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "vikas", 33, Employee.sex.male, "Gurgaon", "vikas.srivastava@abc-company.com"));
		employees.add(new Employee(2, "mike", 34, Employee.sex.male, "Dublin", "mike.george@abc-company.com"));
		employees.add(new Employee(3, "tom", 35, Employee.sex.male, "Dublin", "tom.kinsella@abc-company.com"));
		employees.add(new Employee(4, "radhika", 26, Employee.sex.female, "Delhi", "radhika@abc-company.com"));
		employees.add(new Employee(5, "lakshmi", 29, Employee.sex.female, "Delhi", "lakshmi@abc-company.com"));
		employees.add(new Employee(6, "shikha", 32, Employee.sex.female, "Gurgaon", "shikha@abc-company.com"));
		employees.add(new Employee(7, "shipra", 29, Employee.sex.female, "Gurgaon", "shipra@abc-company.com"));
		employees.add(new Employee(8, "pooja", 27, Employee.sex.female, "Delhi", "pooja@abc-company.com"));
		employees.add(new Employee(9, "vibhav", 38, Employee.sex.male, "Gurgaon", "vibhav@abc-company.com"));
		
		new OfficeSupervisor(employees).performOfficeWork();
	}

	
}

interface Predicate<T>{
	
	boolean evaluate(T t);
}

interface Operate<T>{
	
	void perform(T t);
}

interface Alert{
	
	void perform();
}



class Employee{

	public enum sex{
		male, female
	}
	
	private int id;
	private String name;
	private int age;
	private sex sexx;
	private String address;
	private String email;
	
	public Employee(int id, String name, int age, sex sexx, String address,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sexx = sexx;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public sex getSexx() {
		return sexx;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	
}


