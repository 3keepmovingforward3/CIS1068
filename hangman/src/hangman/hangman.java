package hangman;

import java.util.Scanner;

/**
 * @author bblouin
 * @
 */

public class hangman {

    public static void main(String[] args) {
        String userGuesses;
        int i = 0;

        // Scanner for input
        Scanner k = new Scanner(System.in);
        // Where all the computation is done
        computer c = new computer();

        // hangman visualizations
        hangmanVisual t = new hangmanVisual();
        // print rules
        t.printRules();
        // print gallows
        t.initGallows();
        // print initial spaces
        t.printSpaces(t.getLevel());

        while (i < c.getLevel()) {
            // user prompt
            System.out.print("Enter guess: ");
            // user input char or string
            userGuesses = k.nextLine();
            //remove matches method
            c.removeMatchCharacter(userGuesses);
            // print hangman pieces by knowing what guess user's on
            t.hangmanVisualControl(c.getHangmanStatus());
            i++;
        }
        System.out.println("You lose");
        c.getAnswerChoice();
    }

}