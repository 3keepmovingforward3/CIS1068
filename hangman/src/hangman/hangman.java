package hangman;

import java.util.Scanner;

/**
 * @author bblouin
 * @
 */

public class hangman {

    public static void main(String[] args) {
        // Scanner for input
        Scanner k = new Scanner(System.in);
        // Where all the computation is done
        computer c = new computer();
        // answerHolder size of the level
        int[] answerHolder = new int[c.getLevel()];
        // hangman visualizations
        hangmanVisual t = new hangmanVisual();
        // print rules
        t.printRules();
        // print gallows
        t.initGallows();
        // print initial spaces
        t.printSpaces(t.getLevel());
        // user prompt
        System.out.print("Enter guess: ");
        if (!k.hasNext("[a-z]")) {
            System.out.println("You suck");
        }

    }



}