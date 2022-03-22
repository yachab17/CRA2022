package FKiller.Employee;

import FKiller.Command.Command;
import FKiller.Search.NameOptionSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NameOptionSearchTest {
    static ArrayList<Employee> employees;
    static EmployeeManager employeeManager = EmployeeManager.GetInstance();

    @BeforeAll
    static void setup() {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(12345678, "GILDONG HONG", "CL3", "010-7342-4440", "20020304", "EXP"));
        employees.add(new Employee(22012934, "HEEDO NA", "CL2", "010-1234-5822", "19890601", "PRO"));
        employees.add(new Employee(14028902, "YIJIN BACK", "CL2", "010-8512-3120", "19911018", "ADV"));

        try {
            for (int i = 0; i < employees.size(); i++) {
                employeeManager.addCommand(employees.get(i));
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    @Test
    void firstNameTest() {
        NameOptionSearch nameOptionSearch = new NameOptionSearch();

        Assertions.assertEquals(
                12345678,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-f", "", "name", "GILDONG"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-f", "", "name", "GILDONG"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-f", "", "name", "HEEDO"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-f", "", "name", "HEEDO"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                nameOptionSearch.search(
                    employeeManager.getEmployees(),
                    new Command(new String[]{"SCH", "", "-f", "", "name", "YIJIN"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-f", "", "name", "YIJIN"})
                ).size()
        );
    }

    @Test
    void lastNameTest() {
        NameOptionSearch nameOptionSearch = new NameOptionSearch();

        Assertions.assertEquals(
                12345678,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "name", "HONG"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "name", "HONG"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "name", "NA"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "name", "NA"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "name", "BACK"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                nameOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "name", "BACK"})
                ).size()
        );
    }
}
