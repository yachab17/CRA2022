import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void isValidArgsTest() {
        String[] inputArgs = {"input_20_20.txt", "output_20_20.txt"};
        assertEquals(true, Main.isValidArgs(inputArgs));
    }

    @Test
    void mainTest() {
        String[] inputArgs = {"input_20_20.txt", "output_20_20.txt"};
        Main.main(inputArgs);
    }


}
