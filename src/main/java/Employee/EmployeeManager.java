package Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManager {
    private static EmployeeManager employeeManager = new EmployeeManager();
    private Map<Integer, Employee> employeeMap;

    private EmployeeManager() {
        employeeMap = new HashMap<Integer, Employee>();
    }

    public static EmployeeManager GetInstance() {
        return employeeManager;
    }

    public void addCommand(Employee employee) {
    }

    public List<Employee> deleteCommand(Command command, ISearch searcher) {
        List<Employee> resultEmployees = new ArrayList<Employee>();

        return resultEmployees;
    }

    public List<Employee> updateCommand (Command command, ISearch searcher) {
        List<Employee> resultEmployees = new ArrayList<Employee>();

        return resultEmployees;
    }

    public List<Employee> searchCommand(Command command, ISearch searcher) {
        List<Employee> resultEmployees = new ArrayList<Employee>();

        return resultEmployees;
    }

    public Map<Integer, Employee> getEmployees() {
        return employeeMap;
    }

    public int getTotalEmployees() {
        return employeeMap.size();
    }
}
