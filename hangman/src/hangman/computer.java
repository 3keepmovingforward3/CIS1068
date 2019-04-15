package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class computer extends hangman {
    private Random randLength = new Random();
    private int level;
    private boolean cheat = true;
    private ArrayList answerList;
    private ArrayList listWords;
    // test

    computer() {
        this.listWords = initWordList();
        this.level = setRandLength();
        this.answerList = setAnswerList();
    }

    private int setRandLength() {
        return randLength.nextInt(Collections.max(getListWords(), Comparator.comparing(String::length)).length()) +
                Collections.min(getListWords(), Comparator.comparing(String::length)).length();
    }

    private boolean getCheat() {
        return cheat;
    }

    private void setCheat(boolean cheat) {
        this.cheat = cheat;
    }

    private ArrayList initWordList() {

        String fileName = "word_list.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            //br returns as stream and convert it into a List
            return br.lines().collect(Collectors.toCollection((Supplier<ArrayList>) ArrayList::new));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList getListWords() {
        return listWords;
    }

    private ArrayList<String> setAnswerList() {
        listWords.sort(Comparator.comparingInt(String::length));

        // TODO make answer list
        return null;
    }

    public ArrayList getAnswerList() {
        return answerList;
    }
}
