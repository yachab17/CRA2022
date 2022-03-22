package FKiller;

import FKiller.Command.Command;
import FKiller.Command.CommandParser;
import FKiller.Employee.EmployeeManager;
import FKiller.File.FileManager;
import FKiller.OutputManager.OutputManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(!isValidArgs(args)) return;
        String inputFile = args[0]; // "input_20_20.txt"
        String outputFile = args[1]; // "output_20_20.txt"

        FileManager fileManager = new FileManager();
        List<Command> commandList = new CommandParser().getCommandList(fileManager.loadFileToStringList(inputFile));

        fileManager.saveStringListToFile(getOutputStringList(commandList), outputFile);

    }

    public static List<String> getOutputStringList(List<Command> commandList) {
        OutputManager outputManager = new OutputManager();
        List<String> resultList = new ArrayList<>();
        for (Command command : commandList) {
            String result = outputManager.getOutputString(command, EmployeeManager.GetInstance().excuteCommand(command));
            resultList.add(result);
        }
        return resultList;
    }

    public static boolean isValidArgs(String[] inputArgs) {
        return (inputArgs != null && inputArgs.length == 2);
    }

}
