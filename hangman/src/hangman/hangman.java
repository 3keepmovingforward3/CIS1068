package hangman;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author bblouin
 * @
 */

public class hangman {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Objects.requireNonNull(initWordList()));
        hangmanVisual t = new hangmanVisual();
        t.printRules();

    }

    private static List<String> initWordList() {

        String fileName = "word_list.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            //br returns as stream and convert it into a List
            return br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}