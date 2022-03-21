package Sort;

import Employee.Employee;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;

public class EmployeeNumberComparator implements Comparator<Employee> {

    private final int START_YEAR_1900 = 69;
    private final int END_YEAR_1900 = 99;
    private final int PREFIX_YEAR_1900 = 19;
    private final int PREFIX_YEAR_2000 = 20;

    @Override
    public int compare(Employee employee1, Employee employee2) {
        String employeeNumberStr1 = employee1.getEmployeeNumberToString();
        String employeeNumberStr2 = employee2.getEmployeeNumberToString();

        int prefixYear1 = getFirstTwoNumberOfYear(employeeNumberStr1);
        int prefixYear2 = getFirstTwoNumberOfYear(employeeNumberStr2);

        if(prefixYear1 != prefixYear2) return prefixYear1 - prefixYear2;

        return employeeNumberStr1.compareTo(employeeNumberStr2);

    }

    public int getFirstTwoNumberOfYear(int employeeNumber) {
        return getFirstTwoNumberOfYear(getIntToStringEightDigit(employeeNumber));
    }

    public int getFirstTwoNumberOfYear(String employeeNumberStr) {
        int employeeNumber = Integer.parseInt(employeeNumberStr.substring(0, 2));
        if( (employeeNumber >= START_YEAR_1900) && (employeeNumber <= END_YEAR_1900)) {
            return PREFIX_YEAR_1900;
        }
        return PREFIX_YEAR_2000;
    }

    public String getIntToStringEightDigit(int employeeNumber) {
        return String.format("%08d", employeeNumber);
    }

}
