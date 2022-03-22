package FKiller.Employee;

import FKiller.Command.*;
import java.util.Map;

public class EmployeeUpdater implements EmployeeSync {
    @Override
    public void synchronizeEmployee(Map<Integer, Employee> employeeMap, Employee employee, Command command) throws Exception {
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
}
