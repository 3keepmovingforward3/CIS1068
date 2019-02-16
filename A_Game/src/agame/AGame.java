package agame;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


public class AGame {

    public static void main(String[] args){

        int rounds=0;
        int userWins=0;
        int compWins=0;
        Scanner scan = new Scanner (System.in);
        printInfo();

        while(playInput(scan)) {
            printRules();
            rounds++;
            int playerCharacter = userChoice(scan);
            int computerCharacter = computerChoice();
            if(gameAlgorithm(playerCharacter,computerCharacter)){userWins++;System.out.printf("\nUser Wins\n\n");}
            else {compWins++;System.out.printf("\nComputer Wins\n\n");}

        }
        System.out.printf("\nNumber of Rounds: %d\nUser Wins: %d\nComputer Wins: %d\n",rounds,userWins,compWins);
        scan.close();

    }

    public static void printInfo(){
        System.out.println("To pass the time during long voyages, \n" +
                "Viking sailors would play the two-player game of Havsta.\n");
    }

    public static void printRules(){
        System.out.println("During each round, players choose a move, \n" +
                "which may be either Applaro, Svartrå, Tunholmen, or Godafton. The rules are:\n" +
                "Applaro beats Svartrå and Tunholmen\n" +
                "Svartrå beats Tunholmen\n" +
                "Tunholmen beats Godafton\n" +
                "Godafton beats Applaro and Svartrå\n" +
                "The computer wins in the event of a tie.\n");
    }

    public static Boolean playInput(Scanner scan){
        Boolean t;
        Pattern pattern = Pattern.compile("[YyNn]");
        System.out.printf("Would you like to play a round?: ");
        while(true){
            if(!scan.hasNext(pattern)){
                System.err.printf("Incorrect input: Would you like to play a round?: ");
                scan.next();
            }

        else if(scan.next().matches("[Yy]")){System.out.println();t= true; break;}
        else { t= false;break;}}
    return t;
    }

    public static int userChoice(Scanner scan){
        int t;

        Pattern pattern = Pattern.compile("[0123]");
        System.out.printf("Character Selection:\n(0)Applaro\n(1)Svartrå\n(2)Tunholmen\n(3)Godafton\nChoose your character: ");
        while(true) {
            if (!scan.hasNext(pattern)) {
                System.err.printf("Incorrect input: Try again: ");
                t= scan.nextInt();
            } else return characterOutput(scan.nextInt(), "User");
        }
    }

    public static int computerChoice(){
        Random rnd = new Random();
        return characterOutput(rnd.nextInt(3),"Computer");
    }

    public static boolean gameAlgorithm(int user, int computer) {
        if(user == computer) return false; // tie, quick method return
        switch (user) {
            case(0): //user Appalaro
                switch(computer){
                    case(0): return false; //tie
                    case(1): return true;  //computer Svarta
                    case(2): return true;  //computer Tunholmen
                    case(3): return false; //computer Godafton
                }break;
            case(1): //user Svarta, user should not pick this lol, worst chances of winning
                switch(computer) {
                    case(0): return false; //computer Appalaro
                    case(1): return false; //tie
                    case(2): return true;  //computer Tunholmen
                    case(3): return false; //computer Godafton
                }
                break;
            case(2): //user Tunholem, user should not pick this lol, worst chances of winning
                switch(computer){
                    case(0): return false; //computer Appalaro
                    case(1): return false; //computer Svarta
                    case(2): return false; //tie
                    case(3): return true; //computer Godafton
                }
                break;
            case(3): //Godafton
                switch (computer){
                    case(0): return true; //computer Appalaro
                    case(1): return true; //computer Svarta
                    case(2): return false; //computer Tunholmen
                    case(3): return false; //tie
                }
                break;
            default:
                break;
        }

        return false;
    }

    public static int characterOutput(int t, String u){
        switch(t) {
            case(0):
                System.out.printf("\n%s move choice: Applaro\n",u);
                return t;
            case(1):
                System.out.printf("\n%s move choice: Svartrå\n",u);
                return t;
            case(2):
                System.out.printf("\n%s move choice: Tunholmen\n",u);
                return t;
            case(3):
                System.out.printf("\n%s move choice: Godafton\n",u);
                return t;
            default:
                return -1;
        }
    }
}
