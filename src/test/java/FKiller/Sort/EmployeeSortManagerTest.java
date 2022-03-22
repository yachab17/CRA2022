package FKiller.Sort;

import FKiller.Employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeSortManagerTest {
    ArrayList<Employee> employees;
    EmployeeSortManager employeeSortManager;
    EmployeeNumberComparator employeeNumberComparator;

    @BeforeEach
    void setup() {
        employeeSortManager = new EmployeeSortManager();
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
        System.out.println("Before");

        for(Employee employee:employees) {
            System.out.println(employee.getEmployeeNumberToString());
        }
    }

    @Test
    void sortTest() {
        List<Employee> employeeList = employeeSortManager.sortEmployeeByEmployeeNumber(employees);
        System.out.println("After");
        String[] answer = {"69028902", "75028902", "99028902", "00024732", "07022526", "12345678", "14028902", "22012934"};
        for(int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], employees.get(i).getEmployeeNumberToString());
            System.out.println(employees.get(i).getEmployeeNumberToString());
        }
    }

}
