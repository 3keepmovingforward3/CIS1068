package hangman;

import java.util.Random;

public class computer extends hangman {
    private Random randLength = new Random();
    private boolean cheat = true;

    public computer() {
    }


    public Random getRandLength() {
        return randLength;
    }

    public void setRandLength(Random randLength) {
        this.randLength = randLength;
    }

    public boolean isCheat() {
        return cheat;
    }

    public void setCheat(boolean cheat) {
        this.cheat = cheat;
    }
}
