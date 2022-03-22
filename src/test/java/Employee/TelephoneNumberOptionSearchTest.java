package Employee;

import Command.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TelephoneNumberOptionSearchTest {
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
    void middlePhoneTest() {
        TelephoneNumberOptionSearch telephoneNumberOptionSearch = new TelephoneNumberOptionSearch();

        Assertions.assertEquals(
                12345678,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "7342"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "7342"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "1234"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "1234"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "8512"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-m", "", "phoneNum", "8512"})
                ).size()
        );
    }

    @Test
    void lastPhoneTest() {
        TelephoneNumberOptionSearch telephoneNumberOptionSearch = new TelephoneNumberOptionSearch();

        Assertions.assertEquals(
                12345678,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "phoneNum", "4440"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "phoneNum", "4440"})
                ).size()
        );
        Assertions.assertEquals(
                22012934,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "phoneNum", "5822"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "phoneNum", "5822"})
                ).size()
        );
        Assertions.assertEquals(
                14028902,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "phoneNum", "3120"})
                ).get(0)
        );
        Assertions.assertEquals(
                1,
                telephoneNumberOptionSearch.search(
                        employeeManager.getEmployees(),
                        new Command(new String[]{"SCH", "", "-l", "", "phoneNum", "3120"})
                ).size()
        );
    }
}
