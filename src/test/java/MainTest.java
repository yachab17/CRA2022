import static org.junit.jupiter.api.Assertions.*;

import File.FileManager;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {

    @Test
    void isValidArgsTest() {
        String[] inputArgs = {"input_20_20.txt", "output_20_20.txt"};
        assertEquals(true, Main.isValidArgs(inputArgs));
    }

    @Test
    void mainTest() {
        String input = "input_20_20.txt";
        String output = "output_20_20_1.txt";
        String outputAns = "output_20_20.txt";
        String[] inputArgs = {input, output};
        Main.main(inputArgs);

        List<String> outputLineList  = new FileManager().loadFileToStringList(output);
        List<String> outputLineListAns = new FileManager().loadFileToStringList(outputAns);

        assertAll(
                () -> {
                    for(int i = 0; i < outputLineListAns.size() ; i++) {
                        assertEquals(outputLineListAns.get(i), outputLineList.get(i));
                    }
                }
        );


    }


}
