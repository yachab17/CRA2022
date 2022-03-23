package FKiller.Sort;

import static org.junit.jupiter.api.Assertions.*;

import FKiller.Employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class EmployeeNumberComparatorTest {
    ArrayList<Employee> employees;
    EmployeeNumberComparator employeeNumberComparator;

    @BeforeEach
    void setup() {
        employeeNumberComparator = new EmployeeNumberComparator();
        employees = new ArrayList<Employee>();
        employees.add(new Employee(12345678, "네이버", "CL3", "010-7342-4440", "20020304", "Expert"));
        employees.add(new Employee(22012934, "김삼성", "CL2", "010-1234-5822", "19890601", "Professional"));
        employees.add(new Employee(14028902, "카카오", "CL2", "010-8512-3120", "19911018", "Advanced"));
        employees.add(new Employee(Integer.parseInt("00024732"), "배달의", "CL3", "010-1256-7626", "19931030", "Advanced"));
        employees.add(new Employee(Integer.parseInt("07022526"), "민족", "CL2", "010-64676-1225", "19950418", "Advanced"));
        employees.add(new Employee(99028902, "박쿠팡", "CL3", "010-1111-6420", "19311018", "Advanced"));
        employees.add(new Employee(69028902, "최이버", "CL4", "010-3333-3550", "19490118", "Expert"));
        employees.add(new Employee(75028902, "정스크", "CL4", "010-5555-6610", "19210518", "Expert"));

    }

    @Test
    void getYearTest(){
        int[] employeeNumbers = {12345678, 22012934, 14028902, Integer.parseInt("00024732"), Integer.parseInt("07022526"), 99028902, 69028902, 75028902};
        int[] outputNumbers = {2012345678, 2022012934, 2014028902, 2000024732, 2007022526, 1999028902, 1969028902, 1975028902};

        for(int i = 0; i < employeeNumbers.length; i++){
            int result = employeeNumberComparator.getYYYYFormatFromEmployeeNumber(employeeNumbers[i]);
            assertEquals(outputNumbers[i], result);
            System.out.println("BEFORE / AFTER : " + employeeNumbers[i] + " / " + result );
        }
    }

    @Test
    void getFirstTwoNumberOfYearTest() {
        Employee employee1 = employees.get(0);
        Employee employee2 = employees.get(employees.size()-1);

        System.out.println(employee1.getEmployeeNumberToString());
        System.out.println(employee2.getEmployeeNumberToString());

        assertEquals(12, employeeNumberComparator.getYearFromEmployeeNumber(employee1.getEmployeeNumber()));
        assertEquals(75, employeeNumberComparator.getYearFromEmployeeNumber(employee2.getEmployeeNumber()));

    }

    @Test
    void compareTest() {
        Employee employee1 = employees.get(0);
        Employee employee2 = employees.get(employees.size()-1);

        assertEquals(true, employeeNumberComparator.compare(employee1, employee2) >= 1);

        employee1 = employees.get(0);
        employee2 = employees.get(3);

        assertEquals(true, employeeNumberComparator.compare(employee1, employee2) >= 1);

        employee1 = employees.get(0);
        employee2 = employees.get(2);

        assertEquals(true, employeeNumberComparator.compare(employee1, employee2) <= -1);
    }

}
