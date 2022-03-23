package FKiller.OutputManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import FKiller.Command.Command;
import FKiller.Command.CommandType;
import FKiller.Employee.Employee;
import FKiller.Sort.EmployeeNumberComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OutputManagerTest {
    OutputManager outputManager;
    ArrayList<Employee> employees;
    EmployeeNumberComparator employeeNumberComparator;
    Command command;

    @BeforeEach
    void setup() {
        outputManager = new OutputManager();
        employees = new ArrayList<Employee>();
        employeeNumberComparator = new EmployeeNumberComparator();

        command = mock(Command.class);
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
    void getOutputLineFromString() {
        Command command = mock(Command.class);
        System.out.println("TEST1 : ADD");
        when(command.getType()).thenReturn(CommandType.ADD);
        when(command.isNeedOutputString()).thenReturn(false);
        when(command.getOption1()).thenReturn("-p");
        String result = outputManager.getOutputString(command, employees);
        assertEquals(false, command.isNeedOutputString());
        assertEquals("-p", command.getOption1());
        assertEquals("", result);
        System.out.println(result);


        System.out.println("TEST2 : ADD");
        when(command.getType()).thenReturn(CommandType.ADD);
        when(command.isNeedOutputString()).thenReturn(false);
        when(command.getOption1()).thenReturn(" ");
        result = outputManager.getOutputString(command, employees);
        assertEquals("", result);
        System.out.println(result);

        System.out.println("TEST3 : DEL without -p");
        when(command.getType()).thenReturn(CommandType.DEL);
        when(command.isNeedOutputString()).thenReturn(true);
        when(command.isOptionPrint()).thenReturn(false);
        when(command.getOption1()).thenReturn(" ");
        result = outputManager.getOutputString(command, employees);
        assertEquals("DEL,8\n", result);
        System.out.println(result);

        System.out.println("TEST4 : DEL with p");
        when(command.getType()).thenReturn(CommandType.DEL);
        when(command.isNeedOutputString()).thenReturn(true);
        when(command.isOptionPrint()).thenReturn(true);
        when(command.getOption1()).thenReturn("-p");
        assertAll(
                () -> System.out.println(outputManager.getOutputString(command, employees))
        );


    }


}
