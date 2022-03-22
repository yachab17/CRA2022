package Employee;

import Command.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BirthDayOptionSearchTest {
    static ArrayList<Employee> employees;
    static EmployeeManager employeeManager = EmployeeManager.GetInstance();

    @BeforeAll
    static void setup() {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(12345678, "GILDONG HONG", "CL3", "010-7342-4440", "20020304", "EXP"));
        employees.add(new Employee(22012934, "HEEDO NA", "CL2", "010-1234-5822", "19810601", "PRO"));
        employees.add(new Employee(14028902, "YIJIN BACK", "CL2", "010-8512-3120", "19771018", "ADV"));

        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    @Test
    void yearTest() {
        BirthDatOptionSearch birthDayOptionSearch = new BirthDatOptionSearch();

        Assertions.assertEquals(
                12345678,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-y", "", "birthday", "2002"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-y", "", "birthday", "2002"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-y", "", "phoneNum", "1981"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-y", "", "phoneNum", "1981"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-y", "", "phoneNum", "1977"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-y", "", "phoneNum", "1977"})
                ).size()
        );
    }

    @Test
    void monthTest() {
        BirthDatOptionSearch birthDayOptionSearch = new BirthDatOptionSearch();

        Assertions.assertEquals(
                12345678,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "birthday", "03"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "birthday", "03"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "06"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "06"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "10"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "10"})
                ).size()
        );
    }

    @Test
    void dayTest() {
        BirthDatOptionSearch birthDayOptionSearch = new BirthDatOptionSearch();

        Assertions.assertEquals(
                12345678,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-d", "", "birthday", "04"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-d", "", "birthday", "04"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-d", "", "phoneNum", "01"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-d", "", "phoneNum", "01"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-d", "", "phoneNum", "18"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                birthDayOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-d", "", "phoneNum", "18"})
                ).size()
        );
    }
}
