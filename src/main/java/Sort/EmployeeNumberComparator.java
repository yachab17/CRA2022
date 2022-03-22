package Sort;

import Employee.Employee;

import java.util.Comparator;

public class EmployeeNumberComparator implements Comparator<Employee> {

    private final int START_YEAR_1900 = 69;
    private final int END_YEAR_1900 = 99;
    private final int ADD_YEAR_1900 = 1900;
    private final int ADD_YEAR_2000 = 2000;
    private final int DIVIDE_NUM = 1000000;

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int employeeNumber1 = getYYYYFormatFromEmployeeNumber(employee1.getEmployeeNumber());
        int employeeNumber2 = getYYYYFormatFromEmployeeNumber(employee2.getEmployeeNumber());

        return employeeNumber1 - employeeNumber2;
    }

    public int getYYYYFormatFromEmployeeNumber(int employeeNumber) {
        int firstPart = getFullYearFromEmployeeNumber(employeeNumber);
        int lastPart = getRemainderFromEmployeeNumber(employeeNumber);
        return firstPart * DIVIDE_NUM + lastPart;
    }

    public int getFullYearFromEmployeeNumber(int employeeNumber) {
        int year = getYearFromEmployeeNumber(employeeNumber);
        System.out.println("employeeNumber, year" + employeeNumber + ", " + year);
        if( (year >= START_YEAR_1900) && (year <= END_YEAR_1900)) {
            return year + ADD_YEAR_1900;
        }
        return year + ADD_YEAR_2000;
    }

    public int getYearFromEmployeeNumber(int employeeNumber) {
        return employeeNumber / DIVIDE_NUM;
    }

    public int getRemainderFromEmployeeNumber(int employeeNumber) {
        return employeeNumber % DIVIDE_NUM;
    }

}
