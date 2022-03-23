package FKiller.Search;

import FKiller.Command.Command;
import FKiller.Employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.mockito.Mockito.mock;

public class NormalSearchTest {
    ArrayList<Employee> employees;

    @BeforeEach
    void setup() {
        employees = new ArrayList<Employee>();
        Map<Integer, Employee> employeeMap;

        employees.add(new Employee(12345678, "네이버", "CL3", "010-7342-4440", "20020304", "Expert"));
        employees.add(new Employee(22012934, "김삼성", "CL2", "010-1234-5822", "19890601", "Professional"));
        employees.add(new Employee(14028902, "카카오", "CL2", "010-8512-3120", "19911018", "Advanced"));
        employees.add(new Employee(14020391, "카카오", "CL2", "010-8511-2120", "19901018", "Advanced"));
        employees.add(new Employee(21091281, "카카오", "CL2", "010-4830-2531", "19921018", "Advanced"));

        employeeMap = new HashMap<Integer, Employee>();

        for(int i = 0; i<employees.size(); i++)
            employeeMap.put(employees.get(i).getEmployeeNumber(), employees.get(i));

        int i = 1;
    }

    @Test
    void BirthDaySearchTest(){
        Map<Integer, Employee> employeeMap;
        employeeMap = new HashMap<Integer, Employee>();
        int matchcount = 0;

        for(int i = 0; i<employees.size(); i++)
            employeeMap.put(employees.get(i).getEmployeeNumber(), employees.get(i));

        List<Integer> abc = new ArrayList<>();
        Command command = mock(Command.class);

        Iterator<Map.Entry<Integer, Employee>> entries = employeeMap.entrySet().iterator();

        if(command.getOption1() == String.valueOf('p')){

        }
        else{
            while(entries.hasNext()){
                Map.Entry<Integer, Employee> entry = entries.next();
                if(entry.getValue().getBirthDay().equals("19890601")){
                    abc.add(entry.getKey());

                }
            }
        }

        Assertions.assertEquals(abc.get(0),employees.get(2).getEmployeeNumber());

    }

    @Test
    void TelephoneNumberTest(){
        Map<Integer, Employee> employeeMap;
        employeeMap = new HashMap<Integer, Employee>();
        int matchcount = 0;

        for(int i = 0; i<employees.size(); i++)
            employeeMap.put(employees.get(i).getEmployeeNumber(), employees.get(i));

        List<Integer> abc = new ArrayList<>();
        Command command = mock(Command.class);

        Iterator<Map.Entry<Integer, Employee>> entries = employeeMap.entrySet().iterator();

        if(command.getOption1() == String.valueOf('p')){

        }
        else{
            while(entries.hasNext()){
                Map.Entry<Integer, Employee> entry = entries.next();
                if(entry.getValue().getTelephoneNumber().equals("010-8511-2120")){
                    abc.add(entry.getKey());

                }
            }
        }

        Assertions.assertEquals(abc.get(0),employees.get(2).getTelephoneNumber());
    }

    @Test
    void CertiSearchTest(){
        Map<Integer, Employee> employeeMap;
        employeeMap = new HashMap<Integer, Employee>();
        int matchcount = 0;

        for(int i = 0; i<employees.size(); i++)
            employeeMap.put(employees.get(i).getEmployeeNumber(), employees.get(i));

        List<Integer> abc = new ArrayList<>();
        Command command = mock(Command.class);

        Iterator<Map.Entry<Integer, Employee>> entries = employeeMap.entrySet().iterator();

        if(command.getOption1() == String.valueOf('p')){

        }
        else{
            while(entries.hasNext()){
                Map.Entry<Integer, Employee> entry = entries.next();
                if(entry.getValue().getCertiLevel().equals("19890601")){
                    abc.add(entry.getKey());

                }
            }
        }

        Assertions.assertEquals(abc.get(3),employees.get(2).getCertiLevel());
    }

    @Test
    void NameSearchTest(){
        Map<Integer, Employee> employeeMap;
        employeeMap = new HashMap<Integer, Employee>();
        int matchcount = 0;

        for(int i = 0; i<employees.size(); i++)
            employeeMap.put(employees.get(i).getEmployeeNumber(), employees.get(i));

        List<Integer> abc = new ArrayList<>();
        Command command = mock(Command.class);

        Iterator<Map.Entry<Integer, Employee>> entries = employeeMap.entrySet().iterator();

        if(command.getOption1() == String.valueOf('p')){

        }
        else{
            while(entries.hasNext()){
                Map.Entry<Integer, Employee> entry = entries.next();
                if(entry.getValue().getName().equals("카카오")){
                    abc.add(entry.getKey());

                }
            }
        }

        Assertions.assertEquals(abc.get(1),employees.get(2).getName());
    }
}
