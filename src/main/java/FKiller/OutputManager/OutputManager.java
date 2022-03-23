package FKiller.OutputManager;

import FKiller.Command.Command;
import FKiller.Command.CommandType;
import FKiller.Employee.Employee;
import FKiller.Sort.EmployeeNumberComparator;

import java.util.List;

public class OutputManager {
    public String NONE_OUTPUT_STRING = "NONE";
    public String LINE_BREAK = "\n";
    public String DELIMITER = ",";
    public String PRINT_OPTION = "-p";
    public int MAX_PRINT_COUNT = 5;


    public String getOutputString(Command command, List<Employee> employeeList) {

        if(!isNeedOutputString(command)) return "";
        String commandType = command.getType().name();

        if(employeeList == null || employeeList.size() == 0) {
            return getOutputStringNoOption(commandType, NONE_OUTPUT_STRING);
        }
        if(!isOptionPrint(command)) {
            return getOutputStringNoOption(commandType, Integer.toString(employeeList.size()));
        }

        EmployeeNumberComparator employeeNumberComparator = new EmployeeNumberComparator();
        employeeList.sort(employeeNumberComparator);

        return getOutputStringWithPrintOption(commandType, employeeList);
    }

    public String getOutputStringWithPrintOption(String commandType, List<Employee> employeeList) {
        StringBuilder result = new StringBuilder();
        for( int i = 0; i < MAX_PRINT_COUNT && i < employeeList.size(); i++ ) {
            result.append(commandType).append(DELIMITER).append(toStringFromEmployee(employeeList.get(i)));
        }
        return result.toString();
    }

    public String getOutputStringNoOption(String commandType, String contents) {
        return commandType + DELIMITER + contents + LINE_BREAK;
    }

    public String toStringFromEmployee(Employee employee) {
        StringBuilder result = new StringBuilder();
        return result.append(employee.getEmployeeNumberToString()).append(DELIMITER)
                .append(employee.getName()).append(DELIMITER)
                .append(employee.getCareerLevel()).append(DELIMITER)
                .append(employee.getTelephoneNumber()).append(DELIMITER)
                .append(employee.getBirthDay()).append(DELIMITER)
                .append(employee.getCertiLevel())
                .append(LINE_BREAK).toString();
    }

    public boolean isNeedOutputString(Command command) {
        return !command.getType().equals(CommandType.ADD);
    }

    public boolean isOptionPrint(Command command) {
        return (command.getOption1().equals(PRINT_OPTION));
    }

}