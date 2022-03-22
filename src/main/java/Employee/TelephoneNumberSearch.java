package Employee;

import Command.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TelephoneNumberSearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {

        List<Integer> resultList = new ArrayList<>();

        Iterator<Map.Entry<Integer, Employee>> entries = employeemap.entrySet().iterator();

        // Refactoring 필요
        if((command.getOption2() != null) || (command.getOption3() !=null)){
            TelephoneNumberOptionSearch telephoneNumberOptionSearch = new TelephoneNumberOptionSearch();
            return telephoneNumberOptionSearch.search(employeemap, command);
        }
        else{
            while(entries.hasNext()){
                Map.Entry<Integer, Employee> entry = entries.next();
                if(entry.getValue().getTelephoneNumber().equals(command.getSourceValue())){
                    resultList.add(entry.getKey());

                }
            }
        }

        return resultList;
    }
}
