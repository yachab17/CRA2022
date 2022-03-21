package Sort;

import Employee.Employee;

import java.util.Comparator;

public class EmployeeNumberComparator implements Comparator<Employee> {

    private final int START_YEAR_1900 = 69;
    private final int END_YEAR_1900 = 99;
    private final int PREFIX_YEAR_1900 = 19;
    private final int PREFIX_YEAR_2000 = 20;

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int employeeNumber1 = employee1.getEmployeeNumber();
        int employeeNumber2 = employee2.getEmployeeNumber();

        int prefixYear1 = getFirstTwoNumberOfYear(employeeNumber1);
        int prefixYear2 = getFirstTwoNumberOfYear(employeeNumber2);

        if(prefixYear1 != prefixYear2) return prefixYear1 - prefixYear2;
        //if(employeeNumber1 > employeeNumber2) return 1;
        //return -1;
        return Integer.toString(employeeNumber1).compareTo(Integer.toString(employeeNumber2));

    }

    public int getFullYear(int employeeNumber) {
        String employeeNumberStr = getIntToStringEightDigit(employeeNumber);
        return Integer.parseInt(Integer.toString(getFirstTwoNumberOfYear(employeeNumberStr)) + employeeNumberStr);
    }

    public String convertDoubleDigit(int employeeNumber) {
        String numberString = Integer.toString(employeeNumber);
        if(numberString.length() == 1) {
            return "0" + numberString;
        }
        return numberString;
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
