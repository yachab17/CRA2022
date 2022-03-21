package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputManager {

    private static String docPath = "docs";

    public List<String> loadInputFileToString(String inputFile) {
        List<String> result = new ArrayList<>();
        if(!isValidFileName(inputFile)) return result;

        inputFile = covertRelativePath(inputFile);
        if(!isFileExist(inputFile)) return result;

        return loadInput(inputFile);
    }

    public List<String> loadInput(String inputFile) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String str;
            while ((str = reader.readLine()) != null) {
                result.add(str);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String covertRelativePath(String inputFile) {
        return System.getProperty("user.dir") + "\\" + docPath + "\\" + inputFile;
    }

    public boolean isValidFileName(String name) {
        return (name != null && name.length() <= 15 && name.length() > 0 );
    }

    public boolean isFileExist(String inputFile) {
        return new File(inputFile).exists();
    }

}


