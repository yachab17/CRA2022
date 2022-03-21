import Command.Command;
import Command.CommandParser;
import Employee.EmployeeManager;
import File.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(!isValidArgs(args)) return;
        String inputFile = args[0]; // "input_20_20.txt"
        String outputFile = args[1]; // "output_20_20.txt"

        FileManager fileManager = new FileManager();
        List<Command> commandList = new CommandParser().getCommandList(fileManager.loadFileToStringList(inputFile));

        List<String> resultList = new ArrayList<>();
        

    }

    public static boolean isValidArgs(String[] inputArgs) {
        return (inputArgs != null && inputArgs.length == 2);
    }

}
