package TestCaseGenerator;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TestCaseGen {
    public static ArrayList<Integer> getRandomIntegerWithoutDuplication(int seed, int numberOfDigit, int generateSize, int maxVal, int minVal) {
        Random rnd = new Random(seed);
        ArrayList<Integer> randNumbers = new ArrayList<>();
        HashMap<Integer, Integer> check = new HashMap<Integer, Integer>();
        String numStr = "";
        while (randNumbers.size() < generateSize) {
            numStr = "";
            for (int x = 0; x < numberOfDigit; x++) {
                numStr += Integer.toString(rnd.nextInt(maxVal) + minVal);
            }
            int num = Integer.parseInt(numStr);
            if (check.containsKey(num))
                continue;

            randNumbers.add(num);
            check.put(num, num);
        }

        return randNumbers;
    }

    public static ArrayList<Integer> getRandomInteger(int seed, int numberOfDigit, int generateSize, int maxVal, int minVal) {
        Random rnd = new Random(seed);
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int iGen = 0; iGen < generateSize; iGen++) {
            String numStr = "";
            for (int i = 0; i < numberOfDigit; i++) {
                numStr += Integer.toString(rnd.nextInt(maxVal) + minVal);
            }
            randomNumbers.add(Integer.parseInt(numStr));
        }

        return randomNumbers;
    }

    public static ArrayList<String> getRandomString(int seed, int numberOfChar, int generateSize) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random rnd = new Random(seed);
        ArrayList<String> randomString = new ArrayList<>();
        for (int i = 0; i < generateSize; i++) {
            String generatedString = rnd.ints(leftLimit, rightLimit + 1)
                    .limit(numberOfChar)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            randomString.add(generatedString);
        }

        return randomString;
    }

}
