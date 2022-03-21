import Command.Command;
import Command.CommandParser;
import File.FileInputManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(!isValidArgs(args)) return;
        String inputFile = args[0]; // "input_20_20.txt"
        String outputFile = args[1]; // "output_20_20.txt"

        FileInputManager fileInputManager = new FileInputManager();
        List<Command> commandList = new CommandParser().getCommandList(fileInputManager.loadInput(inputFile));

    }

    public static boolean isValidArgs(String[] inputArgs) {
        return (inputArgs != null && inputArgs.length == 2);
    }

}
