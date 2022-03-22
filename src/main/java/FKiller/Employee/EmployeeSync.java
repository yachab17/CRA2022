package FKiller.Employee;

import FKiller.Command.Command;

import java.util.Map;

public interface EmployeeSync {
    void synchronizeEmployee(Map<Integer, Employee> employeeMap, Employee employee, Command command) throws Exception;
}
