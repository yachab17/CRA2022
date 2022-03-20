import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputManagerTest {

    @Test
    void isValidFileNameTest() {
        FileInputManager fileInputManager = new FileInputManager();
        assertEquals(true, fileInputManager.isValidFileName("input.txt"));
        assertEquals(false, fileInputManager.isValidFileName("inputtttttttttttt.txt"));
        assertEquals(false, fileInputManager.isValidFileName(""));
    }

    @Test
    void isFileExistTest() {
        FileInputManager fileInputManager = new FileInputManager();
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";

        assertEquals(true, fileInputManager.isFileExist(input1));
//        assertEquals(false, fileInputManager.isFileExist("../docs/inputtttttttttttt.txt"));
    }

    @Test
    void loadInputTest() {
        FileInputManager fileInputManager = new FileInputManager();
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";
        String input2 = System.getProperty("user.dir") + "\\docs\\" + "input_20_20.txt";

        String sample = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";

        try {
            List<String> loadString = fileInputManager.loadInput(input1);
            System.out.println(loadString.size());
            assertNotNull(loadString);
            assertEquals(sample, loadString.get(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void loadInputTest2() {
        FileInputManager fileInputManager = new FileInputManager();
        String input1 = System.getProperty("user.dir") + "\\src\\test\\docs\\input_test.txt";
        String input2 = System.getProperty("user.dir") + "\\docs\\" + "input_20_20.txt";

        try {
            List<String> loadString = fileInputManager.loadInput(input2);
            System.out.println(loadString.size());
            assertNotNull(loadString);
            assertEquals(40, loadString.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
