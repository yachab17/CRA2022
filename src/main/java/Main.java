import Command.CommandExecutor;
import Employee.EmployeeManager;
import File.FileManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(!isValidArgs(args)) return;
        String inputFile = args[0]; // "input_20_20.txt"
        String outputFile = args[1]; // "output_20_20.txt"

        FileManager fileManager = new FileManager();
        CommandExecutor commandExecutor = new CommandExecutor();
        List<String> inputLineList = fileManager.loadFileToStringList(inputFile);
        List<String> outputLineList = commandExecutor.commandExecute(inputLineList);
        fileManager.saveStringListToFile(outputLineList, outputFile);

    }



    public static boolean isValidArgs(String[] inputArgs) {
        return (inputArgs != null && inputArgs.length == 2);
    }

}
