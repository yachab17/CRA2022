package Employee;

import Command.Command;

import java.util.*;

public class BirthDaySearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> resultList = new ArrayList<>();

        Iterator<Map.Entry<Integer, Employee>> entries = employeemap.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Integer, Employee> entry = entries.next();
            if (entry.getValue().getBirthDay().equals(command.getSourceValue())) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }
}
