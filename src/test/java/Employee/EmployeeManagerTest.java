package Employee;

import Command.*;
import TestCaseGenerator.TestCaseGen;
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
    void addDuplicationExceptionTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            employeeManager.addCommand(employees.get(0));
            employeeManager.addCommand(employees.get(0));
        });

        Assertions.assertEquals("Duplication Empoyee Number", exception.getMessage());
    }

    @Test
    void deleteTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(22012934));
        when(command.getSourceValue()).thenReturn("name");
        when(command.getSourceColumn()).thenReturn("김삼성");

        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        List<Employee> deletedEmployees = null;
        try {
            deletedEmployees = employeeManager.deleteCommand(command, searcher);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Map<Integer, Employee> employeeMap = employeeManager.getEmployees();
        Assertions.assertFalse(employeeMap.containsKey(deletedEmployees.get(0).getEmployeeNumber()));
    }

    @Test
    void updateTset() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(22012934, 14028902));
        when(command.getSourceValue()).thenReturn(EmployeeParser.CARRIER_LEVEL.toString());
        when(command.getSourceColumn()).thenReturn("CL2");
        when(command.getTargetColumn()).thenReturn(EmployeeParser.CARRIER_LEVEL.toString());
        when(command.getTargetValue()).thenReturn("CL4");

        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        List<Employee> updatedEmployees = null;
        try {
            updatedEmployees = employeeManager.updateCommand(command, searcher);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Map<Integer, Employee> employeeMap = employeeManager.getEmployees();

        Assertions.assertEquals(2, updatedEmployees.size());
        Assertions.assertEquals("CL4", employeeMap.get(updatedEmployees.get(0).getEmployeeNumber()).getCareerLevel());
        Assertions.assertEquals("CL4", employeeMap.get(updatedEmployees.get(1).getEmployeeNumber()).getCareerLevel());
    }

    @Test
    void updateInvalidColumnException() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(22012934, 14028902));
        when(command.getSourceValue()).thenReturn(EmployeeParser.EMPLOYEE_NUMBER.toString());
        when(command.getSourceColumn()).thenReturn("12345678");
        when(command.getTargetColumn()).thenReturn(EmployeeParser.EMPLOYEE_NUMBER.toString());
        when(command.getTargetValue()).thenReturn("123");

        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        Exception exception = Assertions.assertThrows(Exception.class, () -> employeeManager.updateCommand(command, searcher));
        Assertions.assertEquals("Invalid Column Name", exception.getMessage());
    }

    @Test
    void searchWithoutOptionTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(12345678));
        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        List<Employee> foundEmployees = null;
        try {
            foundEmployees = employeeManager.searchCommand(command, searcher);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertEquals("네이버", foundEmployees.get(0).getName());
    }

    @Test
    void searchWithoutOptionTestException() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        ISearch searcher = mock(ISearch.class);
        when(searcher.search(employeeManager.getEmployees(), command)).thenReturn(Arrays.asList(123));
        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            employeeManager.searchCommand(command, searcher);
        });

        Assertions.assertEquals("There is no employeeNumber", exception.getMessage());
    }

    @Test
    void excuteAddCommandTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        when(command.getType()).thenReturn(CommandType.ADD);
        when(command.getEmployee()).thenReturn(new Employee(758237, "홍삼", "CL1", "010-2341-5932", "20201111", "Advanced"));

        employeeManager.excuteCommand(command);
        Assertions.assertTrue(employeeManager.getEmployees().containsKey(758237));
    }

    @Test
    void searchEngineTest() {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        Command command = mock(Command.class);
        when(command.getSourceValue()).thenReturn("19911018");
        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        ISearch search = new BirthDaySearch();
        List<Integer> result = search.search(employeeManager.getEmployees(), command);
        Assertions.assertEquals(14028902, result.get(0));
    }
}

