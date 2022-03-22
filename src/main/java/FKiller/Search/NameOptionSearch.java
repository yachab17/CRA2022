package FKiller.Search;

import FKiller.Command.Command;
import FKiller.Employee.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class NameOptionSearch implements ISearch {
    private static final String OPTION_FIRST_NAME = "-f";
    private static final String OPTION_LAST_NAME = "-l";
    private static final int OPTION_NAME_SEARCHWORD_INDEX = 1;

    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        String searchWord = command.getEtcArg().get(OPTION_NAME_SEARCHWORD_INDEX);
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList = new ArrayList<>();

        if (command.getOption2().equals(OPTION_FIRST_NAME)) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsFirstName(employee.getValue().getName(), searchWord))
                    .collect(Collectors.toList());
        } else if (command.getOption2().equals(OPTION_LAST_NAME)) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsLastName(employee.getValue().getName(), searchWord))
                    .collect(Collectors.toList());
        }

        for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
            result.add(employeeEntry.getKey());
        }

        return result;
    }

    private boolean EqualsFirstName(String fullName, String word) {
        String firstName = fullName.split("\\s")[0];
        return firstName.compareTo(word) == 0;
    }

    private boolean EqualsLastName(String fullName, String word) {
        String firstName = fullName.split("\\s")[1];
        return firstName.compareTo(word) == 0;
    }
}
