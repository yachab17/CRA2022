package Sort;

import Employee.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortManager {
    private final Comparator<Employee> employeeComparator;

    public EmployeeSortManager() {
        this.employeeComparator = new EmployeeNumberComparator();
    }

    public List<Employee> sortEmployeeByEmployeeNumber(List<Employee> employeeList) {
        employeeList.sort(this.employeeComparator);
        return new ArrayList<>(employeeList);
    }
}
