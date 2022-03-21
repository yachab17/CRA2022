package File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static String docPath = "docs";

    public List<String> loadFileToStringList(String inputFile) {
        List<String> result = new ArrayList<>();
        if(!isValidFileName(inputFile)) return result;

        inputFile = covertRelativePath(inputFile);
        if(!isFileExist(inputFile)) return result;

        try {
            result = loadInput(inputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<String> loadInput(String inputFile) throws IOException{
        List<String> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String str;
        while ((str = reader.readLine()) != null) {
            result.add(str);
        }
        reader.close();
        return result;
    }

    public void saveStringListToFile(List<String> resultList, String outputFile) {
        if(resultList == null) return;
        if(!isValidFileName(outputFile)) return;
        outputFile = covertRelativePath(outputFile);
        try {
            saveOutput(resultList, outputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public void saveOutput(List<String> resultList, String outputFile) throws IOException {
        PrintWriter printWriter = new PrintWriter(outputFile);
        for (String result : resultList) {
            if(result == null || result.trim().isEmpty()) continue;
            printWriter.println(result.trim());
        }

        printWriter.flush();
        printWriter.close();
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


