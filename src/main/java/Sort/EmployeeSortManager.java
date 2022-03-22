package Sort;

import Employee.Employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeSortManager {
    private Comparator<Employee> employeeComparator;

    public EmployeeSortManager() {
        this.employeeComparator = new EmployeeNumberComparator();
    }

    public List<Employee> sortEmployeeByEmployeeNumber(List<Employee> employeeList) {
        employeeList.sort(this.employeeComparator);
        return employeeList;
    }
}
