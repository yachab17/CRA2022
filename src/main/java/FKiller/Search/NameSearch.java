package FKiller.Search;

import FKiller.Command.Command;
import FKiller.Employee.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class NameSearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {

        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList;

        // Refactoring 필요
        if((command.getOption2() != null) && (!command.getOption2().equals(" "))
                || (command.getOption3() != null) && (!command.getOption3().equals(" "))){
            NameOptionSearch nameOptionSearch = new NameOptionSearch();
            return nameOptionSearch.search(employeemap, command);
        }
        else{
            filterList = employeemap.entrySet().stream()
                    .filter(employee -> equals(employee.getValue().getName(), command.getSourceValue()))
                    .collect(Collectors.toList());

            for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
                result.add(employeeEntry.getKey());
            }
            return result;
        }
    }

    private boolean equals(String name, String sourceValue) {
        return name.compareTo(sourceValue) == 0;
    }
}
