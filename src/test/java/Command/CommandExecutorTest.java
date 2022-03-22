package Command;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import Employee.Employee;
import Employee.EmployeeManager;
import File.FileManager;
import OutputManager.OutputManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutorTest {
    OutputManager outputManager;
    EmployeeManager employeeManager;
    ArrayList<Employee> employees;
    CommandExecutor commandExecutor;
    Command command;
    List<String> inputLineList;
    List<String> outputLineListAns;

    @BeforeEach
    void setup() {
        employeeManager = EmployeeManager.GetInstance();
        outputManager = new OutputManager();
        commandExecutor = new CommandExecutor();

        FileManager fileManager = new FileManager();
        inputLineList = fileManager.loadFileToStringList("input_20_20.txt");
        outputLineListAns = fileManager.loadFileToStringList("output_20_20.txt");
    }

    @Test
    void getCommandListFromInputListTest() {
        for (String inputLine : inputLineList) {
            System.out.println(inputLine);
        }
        List<Command> commandList = commandExecutor.getCommandListFromInputList(inputLineList);
        assertEquals(40, commandList.size());

        assertEquals(CommandType.ADD, commandList.get(0).getType());
        assertEquals(CommandType.SCH, commandList.get(commandList.size()-1).getType());

        assertAll(
                () -> {
                    for(int i = 0; i < commandList.size() ; i++) {
                        assertEquals(inputLineList.get(i), toStringFromCommand(commandList.get(i)));
                    }
                }
        );


    }

    @Test
    void commandExcutorTest() {
        assertAll(
                () -> commandExecutor.commandExecute(inputLineList)
        );
    }

    public String toStringFromCommand(Command command) {
        String DELIMITER = ",";
        String LINE_BREAK = "\n";
        String result = command.getType().name() + DELIMITER +
                nullToSpace(command.getOption1()) + DELIMITER +
                nullToSpace(command.getOption2()) + DELIMITER +
                nullToSpace(command.getOption3()) + DELIMITER;

        for(int i = 0; i < command.getEtcArg().size(); i ++) {
            result += nullToSpace(command.getEtcArg().get(i));
            if(i != command.getEtcArg().size() - 1) result += DELIMITER;
        }
        return result;
    }

    public String nullToSpace(String str) {
        if(str.equals("")) return " ";
        return str;
    }

}
