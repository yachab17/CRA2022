package FKiller.Employee;

import FKiller.Command.Command;
import FKiller.Command.CommandType;
import FKiller.Command.EmployeeParser;
import FKiller.Search.*;

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
        if (employeeMap.containsKey(employee.getEmployeeNumber()))
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

    public List<Employee> updateCommand(Command command, ISearch searcher) throws Exception {
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

    private void updateColumnValue(Employee employee, Command command) throws Exception {
        String targetColumn = command.getTargetColumn();
        String targetValue = command.getTargetValue();
        if (targetColumn.equals(EmployeeParser.CARRIER_LEVEL.toString())) {
            employee.setCareerLevel(targetValue);
        } else if (targetColumn.equals(EmployeeParser.TELEPHONE_NUMBER.toString())) {
            employee.setTelephoneNumber(targetValue);
        } else if (targetColumn.equals(EmployeeParser.BIRTH_DAY.toString())) {
            employee.setBirthDay(targetValue);
        } else if (targetColumn.equals(EmployeeParser.CERTI_LEVEL.toString())) {
            employee.setCertiLevel(targetValue);
        } else if (targetColumn.equals(EmployeeParser.NAME.toString())) {
            employee.setName(targetValue);
        }
        else {
            throw new Exception("Invalid Column Name");
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

    public List<Employee> excuteCommand(Command command) {
        List<Employee> resultEmployees = new ArrayList<Employee>();
        try {
            if (command.getType() == CommandType.ADD) {
                addCommand(command.getEmployee());
            } else if (command.getType() == CommandType.DEL) {
                resultEmployees = deleteCommand(command, getSearcher(command));
            }
            else if (command.getType() == CommandType.SCH) {
                resultEmployees = searchCommand(command, getSearcher(command));
            }
            else if (command.getType() == CommandType.MOD) {
                resultEmployees = updateCommand(command, getSearcher(command));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultEmployees;
    }

    private ISearch getSearcher(Command command) throws Exception {
        String sourceColumnName = command.getSourceColumn();
        if (sourceColumnName.equals(EmployeeParser.EMPLOYEE_NUMBER.toString())) {
            return new EmployeeNumberSearch();
        }
        else if (sourceColumnName.equals(EmployeeParser.NAME.toString())) {
            return new NameSearch();
        }
        else if (sourceColumnName.equals(EmployeeParser.CARRIER_LEVEL.toString())) {
            return new CLSearch();
        }
        else if (sourceColumnName.equals(EmployeeParser.TELEPHONE_NUMBER.toString())) {
            return new TelephoneNumberSearch();
        }
        else if (sourceColumnName.equals(EmployeeParser.BIRTH_DAY.toString())) {
            return new BirthDaySearch();
        }
        else if (sourceColumnName.equals(EmployeeParser.CERTI_LEVEL.toString())) {
            return new CertiSearch();
        }

        throw new Exception("There is no search Column");
    }

    public Map<Integer, Employee> getEmployees() {
        return employeeMap;
    }

    public int getTotalEmployees() {
        return employeeMap.size();
    }
}