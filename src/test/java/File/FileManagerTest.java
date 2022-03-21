package File;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagerTest {

    @Test
    void isValidFileNameTest() {
        FileManager fileInputManager = new FileManager();
        assertEquals(true, fileInputManager.isValidFileName("input.txt"));
        assertEquals(false, fileInputManager.isValidFileName("inputtttttttttttt.txt"));
        assertEquals(false, fileInputManager.isValidFileName(""));
    }

    @Test
    void isFileExistTest() {
        FileManager fileInputManager = new FileManager();
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";

        assertEquals(true, fileInputManager.isFileExist(input1));
//        assertEquals(false, fileInputManager.isFileExist("../docs/inputtttttttttttt.txt"));
    }

    @Test
    void loadInputTest() {
        FileManager fileManager = new FileManager();
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";
        String input2 = System.getProperty("user.dir") + "\\docs\\" + "input_20_20.txt";
        String input3 = "input_20_20.txt";
        String sample = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";

        try {
            List<String> loadString = fileManager.loadInput(input1);
            List<String> loadString3 = fileManager.loadFileToStringList(input3);
            System.out.println(loadString3.size());
            assertNotNull(loadString3);
            assertEquals(sample, loadString3.get(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void loadInputTest2() {
        FileManager fileManager = new FileManager();
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";
        String input2 = System.getProperty("user.dir") + "\\docs\\" + "input_20_20.txt";

        try {
            List<String> loadString = fileManager.loadInput(input2);
            System.out.println(loadString.size());
            assertNotNull(loadString);
            assertEquals(40, loadString.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void saveStringListToFileTest(){
        FileManager fileManager = new FileManager();
        List<String> output = new ArrayList<>();
        String outputFile = System.getProperty("user.dir") + "\\src\\test\\docs\\output_test.txt";
        assertAll(
                () -> fileManager.saveStringListToFile(output, outputFile),
                () -> assertThrows(IOException.class, () -> fileManager.loadInput(outputFile))
        );

    }

    @Test
    void saveOutputTest() {
        FileManager fileManager = new FileManager();
        List<String> output = new ArrayList<>();
        String outputFile = System.getProperty("user.dir") + "\\src\\test\\docs\\output_test.txt";

        output.add("SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV");
        output.add("MOD,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        output.add("SCH,NONE");
        output.add(" ");

        assertAll(() -> fileManager.saveOutput(output, outputFile));

    }


}
