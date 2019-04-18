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
import java.util.stream.Collectors;

public class computer extends hangman {
    private Random randLength = new Random();
    private int level;
    private boolean cheat;
    private ArrayList<String> answerList;
    private ArrayList<String> listWords;
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

    private ArrayList<String> initWordList() {

        String fileName = "word_list.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            //br returns as stream and convert it into a List
            return br.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> getListWords() {
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

    int getHangmanStatus() {
        return hangmanStatus;
    }

    private void setHangmanStatus(int hangmanStatus) {
        this.hangmanStatus = hangmanStatus;
    }

    int getLevel() {
        return this.level;
    }

    void getAnswerChoice() {
        if (this.currentAnswer == null) {
            this.currentAnswer = this.answerList.get(0);
        }
        System.out.println("Answer is: " + this.currentAnswer);
    }

    //TODO check this logic
    void removeMatchCharacter(String userGuess) {

        Predicate<String> hasCharacter = i -> (i.contains(userGuess));

        // using to check if predicate makes empty
        ArrayList<String> temp = new ArrayList<>(answerList);
        temp.removeIf(hasCharacter);
        if (temp.isEmpty()) {
            Random random = new Random(); // to select random answer
            setCheat(false); // since we can't cheat anymore
            currentAnswer = answerList.get(random.nextInt(answerList.size())); //get string at index save to currentanswer
            this.answerList.clear(); //clear answer list
            this.answerList.add(currentAnswer); //only element in answer list is answer
        }

        // if still cheating
        if (getCheat()) {
            this.answerList.removeIf(hasCharacter);
            setHangmanStatus(getHangmanStatus() + 1);
            this.userGuesses.add(userGuess);
        }
        // if not cheating
        else {
            setHangmanStatus(getHangmanStatus() + 1);
        }
    }

}
