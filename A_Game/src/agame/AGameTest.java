package agame;

import static org.junit.Assert.*;
import java.util.regex.*;


import org.junit.Test;

public class AGameTest {
    @Test
    public void gameAlgorithmTest() {
        // Ties
        assertFalse(AGame.gameAlgorithm(0,0));
        assertFalse(AGame.gameAlgorithm(1,1));
        assertFalse(AGame.gameAlgorithm(2,2));
        assertFalse(AGame.gameAlgorithm(3,3));


        assertTrue(AGame.gameAlgorithm(0,1));
        assertTrue(AGame.gameAlgorithm(0,2));

        assertTrue(AGame.gameAlgorithm(1,2));
        assertFalse(AGame.gameAlgorithm(1,3));

        assertTrue(AGame.gameAlgorithm(2,3));
        assertFalse(AGame.gameAlgorithm(2,0));

        assertTrue(AGame.gameAlgorithm(3,0));
        assertTrue(AGame.gameAlgorithm(3,1));

    }

    @Test
    public void computerChoiceTest(){
        Pattern p = Pattern.compile("[0123]");

        Matcher m = p.matcher(String.valueOf(AGame.computerChoice()));
        String.valueOf(AGame.computerChoice());
        assertTrue(m.matches());
    }

}
