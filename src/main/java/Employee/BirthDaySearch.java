package Employee;

import Command.Command;

import java.util.*;
import java.util.stream.Collectors;

public class BirthDaySearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList;

        if((command.getOption2() != null) && (!command.getOption2().equals(" "))
                || (command.getOption3() != null) && (!command.getOption3().equals(" "))){
           BirthDatOptionSearch birthDatOptionSearch = new BirthDatOptionSearch();
           return birthDatOptionSearch.search(employeemap, command);
        }
        else{
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> equals(employee.getValue().getBirthDay(), command.getSourceValue()))
                    .collect(Collectors.toList());

            for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
                result.add(employeeEntry.getKey());
            }
            return result;
        }
    }

    private boolean equals(String birthDay, String sourceValue) {
        return birthDay.compareTo(sourceValue) == 0;
    }
}
