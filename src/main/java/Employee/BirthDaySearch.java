package Employee;

import Command.Command;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

interface IAdditionalOption {
    String getData(String data);
}

class NoneAdditionalOption implements IAdditionalOption {
    @Override
    public String getData(String data) {
        return data;
    }
}

class FirstNameAdditionalOption implements IAdditionalOption {
    @Override
    public String getData(String data) {
        return data.split(" ")[0];
    }
}

public class BirthDaySearch implements ISearch {
    @Override
    public List<Integer> search(Map<Integer, Employee> employeemap, Command command) {
        // 아래는 팩토리 메서드로 생성된 멤버 변수가 되어야 함
        IAdditionalOption option = new NoneAdditionalOption();
        return employeemap.values().stream().filter(e -> option.getData(e.getBirthDay()) == command.getSourceValue()).map(x -> x.getEmployeeNumber()).collect(Collectors.toList());
    }
}
