package self.poc;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import self.poc.entities.Department;
import self.poc.entities.Employee;
import self.poc.hibernate.HibernateUtil;

public class App {

	public static void main(String[] args) {
		//setupData();
		executeQuery();
	}
	
	/**
	 * Replicating the issue https://coderanch.com/t/474889/databases/avoid-multiple-SELECT-HQL
	 */
	private static void executeQuery() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		// Query to load the gurgaon department with employees
		System.out.println(" ---- Approach 1 ( this approach generates three queries ) ----");
		Query query = session
				.createQuery("select new self.poc.DepartmentVO ( dept.name, dept.location, emp ) "
						+ "from Department dept left join dept.employees as emp where dept.location = 'Gurgaon'");
		List<DepartmentVO> departments = query.list();
		System.out.println(" ---- Approach 1 result ---- " + departments);

		
		System.out.println(" ---- Approach 2 ( this approach generates only one query ) ----");
		query = session
				.createQuery(
						"select dept.name as name, dept.location as location, emp as employee "
								+ "from Department dept left join dept.employees as emp where dept.location = 'Gurgaon'")
				.setResultTransformer(
						Transformers.aliasToBean(DepartmentVO.class));
		departments = query.list();
		System.out.println(" ---- Approach 2 result ---- " + departments);
		
		session.close();
	}

	private static void setupData() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Department productEngineeringDepartment = new Department(
				"Product Enginnering", "Gurgaon");
		Department hrDepartment = new Department("HR", "Noida");

		session.save(productEngineeringDepartment);
		session.save(hrDepartment);

		Employee arvind = new Employee(1, "Arvind Srivastava",
				"Sector - 92, Gurgaon", new Date());
		arvind.setDepartment(productEngineeringDepartment);

		Employee saboor = new Employee(2, "Md Saboor", "Ardee City, Gurgaon",
				new Date());
		saboor.setDepartment(productEngineeringDepartment);

		Employee prateek = new Employee(3, "Prateek Tiwari",
				"Sector 10, Nodia", new Date());
		prateek.setDepartment(hrDepartment);

		session.save(arvind);
		session.save(saboor);
		session.save(prateek);

		session.getTransaction().commit();
		session.close();
	}

}
