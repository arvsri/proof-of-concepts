package self.poc;

import java.util.Date;

import org.hibernate.Session;

import self.poc.entities.Department;
import self.poc.entities.Employee;
import self.poc.hibernate.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Department productEngineeringDepartment = new Department("Product Enginnering", "Gurgaon");
		Department hrDepartment = new Department("HR", "Noide");
		
		session.save(productEngineeringDepartment);
		session.save(hrDepartment);
		
		
		Employee arvind = new Employee(1, "Arvind Srivastava", "Sector - 92, Gurgaon",
				new Date());
		arvind.setDepartment(productEngineeringDepartment);
		
		Employee saboor = new Employee(2, "Md Saboor", "Ardee City, Gurgaon",
				new Date());
		saboor.setDepartment(productEngineeringDepartment);

		Employee prateek = new Employee(3, "Prateek Tiwari", "Sector 10, Nodia",
				new Date());
		prateek.setDepartment(hrDepartment);
		
		session.save(arvind);
		session.save(saboor);
		session.save(prateek);
		
		session.getTransaction().commit();
	}
}
