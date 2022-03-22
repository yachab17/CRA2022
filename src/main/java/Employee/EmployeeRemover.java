package Employee;

import Command.Command;
import java.util.Map;

public class EmployeeRemover implements EmployeeSync {
    @Override
    public void synchronizeEmployee(Map<Integer, Employee> employeeMap, Employee employee, Command command) throws Exception {
        employeeMap.remove(employee.getEmployeeNumber());
    }
}
