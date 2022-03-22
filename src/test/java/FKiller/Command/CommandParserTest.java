package FKiller.Command;

import static org.junit.jupiter.api.Assertions.*;

import FKiller.File.FileManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CommandParserTest {

    @Test
    void getCommandTest() {
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";
        String input2 = System.getProperty("user.dir") + "\\docs\\" + "input_20_20.txt";
        System.out.println(input2);
        List<String> inputList = new ArrayList<>();
        try {
            inputList = new FileManager().loadInput(input2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(40, inputList.size());

        List<Command> commandList = new CommandParser().getCommandList(inputList);

        System.out.println(commandList.get(0).toString());
        assertEquals(CommandType.ADD, commandList.get(0).getType());

        System.out.println(commandList.get(commandList.size()-1).toString());
        assertEquals(CommandType.SCH, commandList.get(commandList.size()-1).getType());

    }
}
