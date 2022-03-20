import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    public static String parseDelimiter =",";

    public List<Command> getCommandList(List<String> inputList) {
        List<Command> result = new ArrayList<>();
        for(int i = 0; i < inputList.size(); i++ ) {
            result.add(getCommand(inputList.get(i)));
        }
        return result;
    }

    public Command getCommand(String line) {
        String[] splitLine = line.split(parseDelimiter);
        return new Command(splitLine);
    }

}
