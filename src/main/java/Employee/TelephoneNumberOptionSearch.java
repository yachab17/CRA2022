package Employee;

import Command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TelephoneNumberOptionSearch implements ISearch {
    private static final String OPTION_MIDDLE_PHONE = "-m";
    private static final String OPTION_LAST_PHONE = "-l";
    private static final int OPTION_PHONE_SEARCHWORD_INDEX = 1;

    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        String searchWord = command.getEtcArg().get(OPTION_PHONE_SEARCHWORD_INDEX);
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList = new ArrayList<>();

        if (command.getOption2() == OPTION_MIDDLE_PHONE) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsMiddlePhone(employee.getValue().getTelephoneNumber(), searchWord))
                    .collect(Collectors.toList());
        } else if (command.getOption2() == OPTION_LAST_PHONE) {
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> EqualsLastPhone(employee.getValue().getTelephoneNumber(), searchWord))
                    .collect(Collectors.toList());
        }

        for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
            result.add(employeeEntry.getKey());
        }

        return result;
    }

    private boolean EqualsMiddlePhone(String fullPhone, String word) {
        String middlePhone = fullPhone.split("-")[1];
        return middlePhone.compareTo(word) == 0;
    }

    private boolean EqualsLastPhone(String fullPhone, String word) {
        String lastPhone = fullPhone.split("-")[2];
        return lastPhone.compareTo(word) == 0;
    }
}
