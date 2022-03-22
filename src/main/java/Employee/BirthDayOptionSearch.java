package Employee;

import Command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BirthDayOptionSearch implements ISearch {
    private static final String OPTION_YEAR = "-y";
    private static final String OPTION_MONTH = "-m";
    private static final String OPTION_DAY = "-d";
    private static final int OPTION_BIRTHDAY_SEARCHWORD_INDEX = 1;

    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        String searchWord = command.getEtcArg().get(OPTION_BIRTHDAY_SEARCHWORD_INDEX);
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList = new ArrayList<>();

        if (command.getOption2().equals(OPTION_YEAR)) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsYear(employee.getValue().getBirthDay(), searchWord))
                    .collect(Collectors.toList());
        } else if (command.getOption2().equals(OPTION_MONTH)) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsMonth(employee.getValue().getBirthDay(), searchWord))
                    .collect(Collectors.toList());
        } else if (command.getOption2().equals(OPTION_DAY)) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsDay(employee.getValue().getBirthDay(), searchWord))
                    .collect(Collectors.toList());
        }

        for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
            result.add(employeeEntry.getKey());
        }

        return result;
    }

    private boolean EqualsYear(String birthday, String word) {
        String year = birthday.substring(0, 4);
        return year.compareTo(word) == 0;
    }

    private boolean EqualsMonth(String birthday, String word) {
        String month = birthday.substring(4, 6);
        return month.compareTo(word) == 0;
    }

    private boolean EqualsDay(String birthday, String word) {
        String day = birthday.substring(6, 8);
        return day.compareTo(word) == 0;
    }
}
