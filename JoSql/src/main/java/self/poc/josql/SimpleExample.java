package self.poc.josql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.josql.Query;
import org.josql.QueryResults;


public class SimpleExample {

    public static void main(String[] args) throws Exception {

        List<Employee> employees = new ArrayList<Employee>();

        Department d1 = new Department(1, "Product Engineering");
        employees.add(new Employee(101, "A101", "M", getDate("15/03/2010"), "Permanent", d1));
        employees.add(new Employee(102, "A102", "F", getDate("15/03/2011"), "Temporary", d1));
        employees.add(new Employee(103, "A103", "F", getDate("15/03/2012"), "Permanent", d1));
        employees.add(new Employee(104, "A104", "M", getDate("15/03/2013"), "Permanent", d1));
        employees.add(new Employee(105, "A105", "M", getDate("15/11/2010"), "Temporary", d1));
        employees.add(new Employee(106, "A106", "F", getDate("15/02/2010"), "Permanent", d1));

        Department d2 = new Department(2, "Business Development");
        employees.add(new Employee(201, "A201", "M", getDate("15/03/2010"), "Permanent", d2));
        employees.add(new Employee(202, "A202", "F", getDate("15/03/2011"), "Temporary", d2));
        employees.add(new Employee(203, "A203", "F", getDate("15/03/2012"), "Permanent", d2));
        employees.add(new Employee(204, "A204", "M", getDate("15/03/2013"), "Permanent", d2));
        employees.add(new Employee(205, "A205", "M", getDate("15/11/2010"), "Temporary", d2));
        employees.add(new Employee(206, "A206", "F", getDate("15/02/2010"), "Permanent", d2));

        Department d3 = new Department(3, "Sales");
        employees.add(new Employee(301, "A301", "M", getDate("15/03/2010"), "Permanent", d3));
        employees.add(new Employee(302, "A302", "F", getDate("15/03/2011"), "Temporary", d3));
        employees.add(new Employee(303, "A303", "F", getDate("15/03/2012"), "Permanent", d3));
        employees.add(new Employee(304, "A304", "M", getDate("15/03/2013"), "Permanent", d3));
        employees.add(new Employee(305, "A305", "M", getDate("15/11/2010"), "Temporary", d3));
        employees.add(new Employee(306, "A306", "F", getDate("15/02/2010"), "Permanent", d3));

        Department d4 = new Department(4, "IT Support");
        employees.add(new Employee(401, "A401", "M", getDate("15/03/2010"), "Permanent", d4));
        employees.add(new Employee(402, "A402", "F", getDate("15/03/2011"), "Temporary", d4));
        employees.add(new Employee(403, "A403", "F", getDate("15/03/2012"), "Permanent", d4));

        final String query =
                " select name,department.name from self.poc.josql.Employee where employmentType = 'Permanent' and dateOfJoining between "
                        + " :fromDate and :toDate order by department.name";
        Query q = new Query();
        q.setVariable("fromDate", getDate("01/01/2012"));
        q.setVariable("toDate", getDate("31/12/2012"));
        q.parse(query);

        QueryResults results = q.execute(employees);
        for (Object o : results.getResults()) {
            ArrayList<?> result = (ArrayList<?>) o;
            System.out.println(result.get(0) + "   " + result.get(1));
        }
    }

    private static Date getDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(date);
    }

}
