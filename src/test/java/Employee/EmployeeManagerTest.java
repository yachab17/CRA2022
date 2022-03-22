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
        EmployeeManager employeeManager = spy(EmployeeManager.GetInstance());

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
            deletedEmployees = employeeManager.runCommand(command, searcher, new EmployeeRemover());
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
            updatedEmployees = employeeManager.runCommand(command, searcher, new EmployeeUpdater());
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

        Exception exception = Assertions.assertThrows(Exception.class, () -> employeeManager.runCommand(command, searcher, new EmployeeUpdater()));
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
            foundEmployees = employeeManager.runCommand(command, searcher, new EmployeeSearcher());
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
            employeeManager.runCommand(command, searcher, new EmployeeSearcher());
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

    @Test
    void searchEngineMassTest() throws NoSuchFieldException, IllegalAccessException {
        EmployeeManager employeeManager = EmployeeManager.GetInstance();
        System.out.println("Gen Rand Start");
        int genSize = 60000;
        ArrayList<Integer> employeesNumbers = TestCaseGen.getRandomIntegerSequenceShuffle(10, genSize);
        ArrayList<String> names = TestCaseGen.getRandomString(10, 6, genSize);
        ArrayList<Integer> carrerLevels = TestCaseGen.getRandomInteger(11, 1, genSize, 4, 1);
        ArrayList<Integer> telephoneNumbersMid = TestCaseGen.getRandomIntegerSequenceShuffle(10, genSize);
        ArrayList<Integer> telephoneNumbersEnd = TestCaseGen.getRandomIntegerSequenceShuffle(10, genSize);
        ArrayList<Integer> birthDays = TestCaseGen.getRandomIntegerSequenceShuffle(10, genSize);
        ArrayList<Integer> certiLevels = TestCaseGen.getRandomInteger(15, 1, genSize, 3, 0);
        String certiLevelStr[] = new String[4];
        certiLevelStr[0] = "Intermediate";
        certiLevelStr[1] = "Advanced";
        certiLevelStr[2] = "Professional";
        certiLevelStr[3] = "Expert";
        System.out.println("Gen Rand Complete");

        System.out.println("Add Command Start");
        ArrayList<Employee> genEmployees = new ArrayList<Employee>();
        Employee testEmployees = null;
        for (int i = 0; i < genSize; i++) {
            Employee employee = new Employee(employeesNumbers.get(i), names.get(i), String.format("CL%d", carrerLevels.get(i)),
                    String.format("010-%04d-%04d", telephoneNumbersMid.get(i), telephoneNumbersEnd.get(i)), String.format("%08d", birthDays.get(i)),
                    certiLevelStr[certiLevels.get(i)]);
            genEmployees.add(employee);

            if (i == genSize / 2)
                testEmployees = employee;
        }
        System.out.println("Add Command Complete");

        try {
            for (int i = 0; i < genEmployees.size(); i++) {
                employeeManager.addCommand(genEmployees.get(i));
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

        Command command = mock(Command.class);
        when(command.getSourceValue()).thenReturn(testEmployees.getBirthDay());
        ISearch search = new BirthDaySearch();
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        List<Integer> result = search.search(employeeManager.getEmployees(), command);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("function run time (ms) : "+secDiffTime);
        Assertions.assertEquals(testEmployees.getEmployeeNumber(), result.get(0));
    }
}

