package Employee;

import Command.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TelephoneNumberSearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList;

        // Refactoring 필요
        if((command.getOption2() != null) && (!command.getOption2().equals(" "))
                || (command.getOption3() != null) && (!command.getOption3().equals(" "))){
            TelephoneNumberOptionSearch telephoneNumberOptionSearch = new TelephoneNumberOptionSearch();
            return telephoneNumberOptionSearch.search(employeemap, command);
        }
        else{
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> equals(employee.getValue().getTelephoneNumber(), command.getSourceValue()))
                    .collect(Collectors.toList());

            for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
                result.add(employeeEntry.getKey());
            }
            return result;
        }
    }

    private boolean equals(String telephoneNumber, String sourceValue) {
        return telephoneNumber.compareTo(sourceValue) == 0;
    }
}
