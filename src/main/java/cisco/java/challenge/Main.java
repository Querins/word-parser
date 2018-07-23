package cisco.java.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        switch(args.length) {
            case 0:
                System.out.println("Provide an argument which contains path to text file to be processed");
                break;
            case 1:
                try {
                    Map<String, Integer> result = parseWords(args[0]);
                    System.out.println(result);
                } catch (IOException e) {
                    System.out.println("IO Exception occurred");
                }
                break;
            default:
                System.out.println("Too many arguments");
        }

    }

    public static Map<String,Integer> parseWords(String filePath) throws IOException {
        Pattern nonWord = Pattern.compile("[^\\w]");
        Map<String, Integer> result = new HashMap<>();
        Files.lines(Paths.get(filePath)).forEach(line -> {

            String[] words = nonWord.split(line);

            for(String word: words) {
                result.merge(word, 1, Integer::sum);
            }
        });

        return result;
    }

}
