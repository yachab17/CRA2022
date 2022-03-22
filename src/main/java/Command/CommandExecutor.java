package Command;

import Employee.EmployeeManager;
import OutputManager.OutputManager;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    public static EmployeeManager employeeManager;
    public static CommandParser commandParser;
    public static OutputManager outputManager;

    public CommandExecutor() {
        employeeManager = EmployeeManager.GetInstance();
        commandParser = new CommandParser();
        outputManager = new OutputManager();
    }

    public List<String> commandExecute(List<String> inputLineList) {
        return getOutputLineList(getCommandListFromInputList(inputLineList));
    }

    public List<Command> getCommandListFromInputList(List<String> inputLineList) {
        return commandParser.getCommandList(inputLineList);
    }

    public List<String> getOutputLineList(List<Command> commandList) {
        List<String> resultList = new ArrayList<>();
        for (Command command : commandList) {
            String result = outputManager.getOutputString(command, employeeManager.excuteCommand(command));
            resultList.add(result);
        }
        return resultList;
    }

}
