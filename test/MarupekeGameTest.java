import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class MarupekeGameTest {

    @Test
    public void testMarupekeGame1() {
        MarupekeGame game1 = new MarupekeGame(11);
        assertEquals(10, game1.getSize());
    }

    @Test
    public void testMarupekeGame2() {
        MarupekeGame game1 = new MarupekeGame(2);
        assertEquals(3, game1.getSize());
    }

    @Test
    public void testMarupekeGame3() {
        MarupekeGame game1 = new MarupekeGame(8);
        assertEquals(18, game1.getSize());
    }

    @Test
    public void testSetSolid() {
        MarupekeGame game1 = new MarupekeGame(8);
        assertTrue(game1.setSolid(2, 1));
    }

    @Test
    public void testSetX() {
        MarupekeGame game1 = new MarupekeGame(8);
        assertTrue(game1.setX(3, 4, true));
    }

    @Test
    public void testSetO() {
        MarupekeGame game1 = new MarupekeGame(8);
        assertTrue(game1.setO(3, 4, true));
    }

    @Test
    public void testIsLegalgrid() {
        MarupekeGame game1 = new MarupekeGame(8);
        assertTrue(game1.isLegalGrid());
    }

    @Test
    public void testRandomPuzzle() {
        MarupekeGame game1 = new MarupekeGame(8);
        assertTrue(Objects.requireNonNull(MarupekeGame.randomPuzzle(8, 3, 3, 3)).isLegalGrid());
    }
}