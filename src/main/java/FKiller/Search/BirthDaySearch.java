package FKiller.Search;

import FKiller.Command.Command;
import FKiller.Employee.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class BirthDaySearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList;

        if((command.getOption2() != null) && (!command.getOption2().equals(" "))
                || (command.getOption3() != null) && (!command.getOption3().equals(" "))){
           BirthDayOptionSearch birthDayOptionSearch = new BirthDayOptionSearch();
           return birthDayOptionSearch.search(employeemap, command);
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
