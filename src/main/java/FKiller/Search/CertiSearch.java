package FKiller.Search;

import FKiller.Command.Command;
import FKiller.Employee.Employee;
import FKiller.Search.ISearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CertiSearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Employee>> filterList;

        filterList = employeemap.entrySet().stream()
                .filter(employee -> equals(employee.getValue().getCertiLevel(), command.getSourceValue()))
                .collect(Collectors.toList());

        for(Map.Entry<Integer, Employee> employeeEntry : filterList) {
            result.add(employeeEntry.getKey());
        }
        return result;
    }

    private boolean equals(String certilevel, String sourceValue) {
        return certilevel.compareTo(sourceValue) == 0;
    }
}
