package hangman;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bblouin
 * @
 */

public class hangman {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        ArrayList<String> l = new ArrayList<>();
        computer c = new computer();
        hangmanVisual t = new hangmanVisual();
        t.printRules();
        t.initGallows();
        System.out.print("Enter guess: ");


    }



}