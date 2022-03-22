package Employee;

import Command.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CertiSearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        List<Integer> resultList = new ArrayList<>();

        Iterator<Map.Entry<Integer, Employee>> entries = employeemap.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Integer, Employee> entry = entries.next();
            if (entry.getValue().getCertiLevel().equals(command.getSourceValue())) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }
}
