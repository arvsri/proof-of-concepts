package self.poc.josql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.josql.Query;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import org.josql.QueryResults;


public class StressTestExample {



    public static void main(String[] args) throws Exception {
        setupLargeNumberOfEmployees(10000000, 503);
        runTest(10, 3);
        runTest(100, 31);
        runTest(1000, 311);
        runTest(10000, 3019);
        runTest(100000, 30059);
        runTest(1000000, 304883);
        runTest(10000000, 1299827);
    }

    private static void runTest(int numberOfEmployees, int numberOfDepatments)
            throws ParseException, QueryParseException, QueryExecutionException {
        System.out.println("Setting up numberOfEmployees = "
                + numberOfEmployees
                + " and numberOfDepatments = "
                + numberOfDepatments);

        long startTime = new Date().getTime();
        List<Employee> employees =
                setupLargeNumberOfEmployees(numberOfEmployees, numberOfDepatments);
        System.out.println(" Data Setup time = " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        final String query =
                " select * from self.poc.josql.Employee where employmentType = 'Permanent' and dateOfJoining between "
                        + " :fromDate and :toDate order by department.name";
        Query q = new Query();
        q.setVariable("fromDate", getDate("01/01/2014"));
        q.setVariable("toDate", getDate("31/12/2014"));
        q.parse(query);


        QueryResults result = q.execute(employees);
        System.out.println(" Query Execution using JoSql - Time Taken = " + (new Date().getTime() - startTime));
        List<Employee> queryResult = result.getResults();

        startTime = new Date().getTime();
        employees = setupLargeNumberOfEmployees(numberOfEmployees, numberOfDepatments);
        System.out.println(" Data Setup time = " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        Date fromDate = getDate("01/01/2014");
        Date toDate = getDate("31/12/2014");
        
        List<Employee> matchedEmployees = new ArrayList<Employee>();
        for (Employee e : employees) {
            if (e.getEmploymentType().equals("Permanent")) {
                if (e.getDateOfJoining().after(fromDate) && e.getDateOfJoining().before(toDate)) {
                    matchedEmployees.add(e);
                }
            }
        }
        Collections.sort(matchedEmployees, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getDepartment().getName().compareTo(o2.getDepartment().getName());
            }
        });

        System.out.println(" Execution in java - Time Taken = " + (new Date().getTime() - startTime));

        System.out.println(" ------------- Verifying if both fetched the same result ------------------------");
        System.out.println("Query Result Count " + queryResult.size() + "  Java result count " + matchedEmployees.size());

        if (queryResult.size() != 0) {
            System.out.println(" Id of "
                    + queryResult.size()

                    + " Employee - Query Result "
                    + queryResult.get(queryResult.size() - 1).getId()
                    + "  Java result  "
                    + matchedEmployees.get(queryResult.size() - 1).getId());
        }
    }

    private static List<Employee> setupLargeNumberOfEmployees(int employeeCount, int departmentCount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        Map<Integer, Department> departments = new HashMap<Integer, Department>();
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < employeeCount; i++) {
            int deptId = i % departmentCount;
            if (departments.get(deptId) == null) {
                departments.put(deptId, new Department(deptId, "D" + deptId));
            }

            cal.add(Calendar.HOUR, -1);
            employees.add(new Employee(
                    i,
                    "A" + i,
                    i % 2 == 0 ? "M" : "F",
                    cal.getTime(),
                    i % 9 == 0 ? "Temporary" : "Permanent",
                    departments.get(deptId)));
        }

        return employees;
    }

    private static Date getDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(date);
    }

}
