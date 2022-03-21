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

    public void addCommand(Employee employee) throws Exception {
        if(employeeMap.containsKey(employee.getEmployeeNumber()))
            throw new Exception("Duplication Empoyee Number");

        employeeMap.put(employee.getEmployeeNumber(), employee);
    }

    public List<Employee> deleteCommand(Command command, ISearch searcher) throws Exception {
        List<Employee> resultEmployees = new ArrayList<Employee>();
        List<Integer> foundEmployeeNumbers = searcher.search(employeeMap, command);

        for (int employeeNumber : foundEmployeeNumbers) {
            if (!employeeMap.containsKey(employeeNumber))
                throw new Exception("There is no employeeNumber");

            resultEmployees.add((Employee) employeeMap.get(employeeNumber).clone());
            employeeMap.remove(employeeNumber);
        }

        return resultEmployees;
    }

    public List<Employee> updateCommand (Command command, ISearch searcher) throws Exception {
        List<Employee> resultEmployees = new ArrayList<Employee>();
        List<Integer> foundEmployeeNumbers = searcher.search(employeeMap, command);

        for (int employeeNumber : foundEmployeeNumbers) {
            if (!employeeMap.containsKey(employeeNumber))
                throw new Exception("There is no employeeNumber");

            resultEmployees.add((Employee) employeeMap.get(employeeNumber).clone());
            updateColumnValue(employeeMap.get(employeeNumber), command);
        }

        return resultEmployees;
    }

    private void updateColumnValue(Employee employee, Command command) {
        String targetColumn = command.getTargetColumn();
        String targetValue = command.getTargetValue();
        if(targetColumn == "careerLevel") {
            employee.setCareerLevel(targetValue);
        }
        else if(targetColumn =="telephoneNumber") {
            employee.setTelephoneNumber(targetValue);
        }
        else if(targetColumn == "birthDay") {
            employee.setBirthDay(targetValue);
        }
        else if(targetColumn == "certiLevel") {
            employee.setCertiLevel(targetValue);
        }
    }


    public List<Employee> searchCommand(Command command, ISearch searcher) throws Exception {
        List<Employee> resultEmployees = new ArrayList<Employee>();
        List<Integer> foundEmployeeNumbers = searcher.search(employeeMap, command);
        for (int employeeNumber : foundEmployeeNumbers) {
            if (!employeeMap.containsKey(employeeNumber))
                throw new Exception("There is no employeeNumber");

            resultEmployees.add(employeeMap.get(employeeNumber));
        }

        return resultEmployees;
    }

    public Map<Integer, Employee> getEmployees() {
        return employeeMap;
    }

    public int getTotalEmployees() {
        return employeeMap.size();
    }
}
