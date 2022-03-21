package Sort;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import Employee.*;
import File.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        int[] employeeNumbers = {69, 70, 85, 88, 99, 00, 01, 05, 10, 15, 19, 22};
        int[] outputNumbers = {19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20};

        for(int i = 0; i < employeeNumbers.length; i++){
            int result = employeeNumberComparator.getFirstTwoNumberOfYear(employeeNumbers[i]);
            assertEquals(outputNumbers[i], result);
        }

        int[] outputNumbers2 = {1969, 1970, 1985, 1988, 1999, 2000, 2001, 2005, 2010, 2015, 2019, 2022};
        for(int i = 0; i < employeeNumbers.length; i++){
            int result = employeeNumberComparator.getFullYear(employeeNumbers[i]);
            assertEquals(outputNumbers2[i] , result);
            System.out.println(result);
        }
    }

    @Test
    void getFirstTwoNumberOfYearTest() {
        Employee employee1 = employees.get(0);
        Employee employee2 = employees.get(employees.size()-1);

        System.out.println(employee1.getEmployeeNumber());
        System.out.println(employee2.getEmployeeNumber());

        assertEquals(20, employeeNumberComparator.getFirstTwoNumberOfYear(Integer.toString(employee1.getEmployeeNumber())));
        assertEquals(19, employeeNumberComparator.getFirstTwoNumberOfYear(Integer.toString(employee2.getEmployeeNumber())));

    }

    @Test
    void compareTest() {
        Employee employee1 = employees.get(0);
        Employee employee2 = employees.get(employees.size()-1);

        assertEquals(1, employeeNumberComparator.compare(employee1, employee2));

        employee1 = employees.get(0);
        employee2 = employees.get(3);

        assertEquals(1, employeeNumberComparator.compare(employee1, employee2));

    }

}
