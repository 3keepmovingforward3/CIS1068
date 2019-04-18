package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class computer extends hangman {
    private Random randLength = new Random();
    private int level;
    private boolean cheat;
    private ArrayList<String> answerList;
    private ArrayList listWords;
    private String currentAnswer;
    private int hangmanStatus;
    private ArrayList<String> userGuesses = new ArrayList<>();

    computer() {
        setCheat(true);
        this.listWords = initWordList();
        this.level = setRandLength();
        this.answerList = setAnswerList();
        this.hangmanStatus = 0;
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
        Comparator<String> f = Comparator.comparing(String::length);
        Predicate<String> lesserThan = i -> (i.length() < level);
        Predicate<String> moreThan = i -> (i.length() > level);
        this.listWords.sort(f);
        this.listWords.removeIf(lesserThan);
        this.listWords.removeIf(moreThan);
        return listWords;
    }

    public int getHangmanStatus() {
        return hangmanStatus;
    }

    public void setHangmanStatus(int hangmanStatus) {
        this.hangmanStatus = hangmanStatus;
    }

    private ArrayList<String> getAnswerList() {
        return answerList;
    }

    int getLevel() {
        return this.level;
    }

    void getAnswerChoice() {
        System.out.println(this.currentAnswer);
    }

    void removeMatchCharacter(String userGuess) {
        Predicate<String> hasCharacter = i -> (i.contains(userGuess));

        if (answerList.removeIf(hasCharacter) && getCheat() && this.answerList.size() > 1) {
            this.answerList.removeIf(hasCharacter);
            setHangmanStatus(getHangmanStatus() + 1);
            this.userGuesses.add(userGuess);
        } else if (this.answerList.size() == 1) {
            this.currentAnswer = answerList.get(0);
            setCheat(false);
        }
    }

}
