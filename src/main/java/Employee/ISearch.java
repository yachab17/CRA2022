package Employee;

import java.util.Map;
import java.util.List;

public interface ISearch {
    List<Integer> search(Map<Integer, Employee> employeemap, Command command);
}