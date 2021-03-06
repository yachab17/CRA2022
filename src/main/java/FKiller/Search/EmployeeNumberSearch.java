package FKiller.Search;

import FKiller.Command.Command;
import FKiller.Employee.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmployeeNumberSearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> resultList = new ArrayList<>();

        Iterator<Map.Entry<Integer, Employee>> entries = employeemap.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Integer, Employee> entry = entries.next();
            if (entry.getValue().getEmployeeNumberToString().equals(command.getEtcArg().get(1))) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }
}
