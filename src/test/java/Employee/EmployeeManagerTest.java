package Employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.*;
import java.util.ArrayList;

public class EmployeeManagerTest {
    ArrayList<Employee> employees;

    @BeforeEach
    void setup() {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(12345678, "네이버", "CL3", "010-7342-4440", "20020304", "Expert"));
        employees.add(new Employee(22012934, "김삼성", "CL2", "010-1234-5822", "19890601", "Professional"));
        employees.add(new Employee(14028902, "카카오", "CL2", "010-8512-3120", "19911018", "Advanced"));
    }

    @Test
    void addTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        Assertions.assertEquals(3, employeeManager.getTotalEmployees());
    }

    @Test
    void deleteTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(22012934));
        when(command.getSourceValue()).thenReturn("name");
        when(command.getSourceColumn()).thenReturn("김삼성");

        for (int i = 0; i < employees.size(); i++) {
            employeeManager.addCommand(employees.get(i));
        }
        List<Employee> deletedEmployees = employeeManager.deleteCommand(command, searcher);
        Map<Integer, Employee> employeeMap = employeeManager.getEmployees();

        Assertions.assertFalse(employeeMap.containsKey(deletedEmployees.get(0).getEmployeeNumber()));
    }

    @Test
    void updateTset() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(22012934, 14028902));
        when(command.getSourceValue()).thenReturn("careerLevel");
        when(command.getSourceColumn()).thenReturn("CL2");
        when(command.getTargetColumn()).thenReturn("careerLevel");
        when(command.getTargetValue()).thenReturn("CL4");

        for (int i = 0; i < employees.size(); i++) {
            employeeManager.addCommand(employees.get(i));
        }
        List<Employee> updatedEmployees = employeeManager.updateCommand(command, searcher);
        Map<Integer, Employee> employeeMap = employeeManager.getEmployees();

        Assertions.assertEquals(2, updatedEmployees.size());
        Assertions.assertEquals("CL4", employeeMap.get(updatedEmployees.get(0).getEmployeeNumber()).getCareerLevel());
        Assertions.assertEquals("CL4", employeeMap.get(updatedEmployees.get(1).getEmployeeNumber()).getCareerLevel());
    }

    @Test
    void searchWithoutOptionTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(12345678));

        for (int i = 0; i < employees.size(); i++) {
            employeeManager.addCommand(employees.get(i));
        }
        List<Employee> foundEmployees = employeeManager.searchCommand(command, searcher);

        Assertions.assertEquals("네이버", foundEmployees.get(0).getName());
    }
}

