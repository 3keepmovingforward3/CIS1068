package hangman;

class hangmanVisual {

    public void initGallows() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |      ");
        System.out.println("  |      ");
        System.out.println("  |      ");
        System.out.println(" _|__    ");
    }

    public void addHead() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |     O");
        System.out.println("  |      ");
        System.out.println("  |      ");
        System.out.println(" _|__    ");
    }

    public void addBody() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |     O");
        System.out.println("  |     |");
        System.out.println("  |      ");
        System.out.println(" _|__    ");
    }

    public void addArm1() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |     O");
        System.out.println("  |   \\|");
        System.out.println("  |      ");
        System.out.println(" _|__    ");
    }

    public void addArm2() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |     O");
        System.out.println("  |    \\|/");
        System.out.println("  |      ");
        System.out.println(" _|__    ");
    }

    public void addLeg1() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |     O");
        System.out.println("  |    \\|/");
        System.out.println("  |    /");
        System.out.println(" _|__    ");
    }

    public void addLeg2() {
        System.out.println("  _______   ");
        System.out.println("  |     |");
        System.out.println("  |     O");
        System.out.println("  |    \\|/");
        System.out.println("  |    / \\");
        System.out.println(" _|__    ");
    }

    void printRules() {
        System.out.println("\nHangman is a guessing game for two or more players. \nOne player (computer) " +
                "thinks of a word\nand the other(s) (users) try to guess it \nby suggesting letters " +
                "within a certain number of guesses.");
    }
}
