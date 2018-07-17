package cisco.java.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        switch(args.length) {
            case 0:
                System.out.println("");
                break;
            case 1:
                try {
                    Map<String, Integer> result = new HashMap<>();
                    Files.lines(Paths.get(args[0])).forEach(line -> {

                        String[] words = line.split("\\s+");

                        for(String word: words) {
                            word = word.replaceAll("[^\\w]", "");
                            result.merge(word, 1, Integer::sum);
                        }
                    });
                    System.out.println(result);
                } catch (IOException e) {
                    System.out.println("IO Exception occurred");
                }
                break;
            default:
                System.out.println("Too many arguments");
        }

    }
}
