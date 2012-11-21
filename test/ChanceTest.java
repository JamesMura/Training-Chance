import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {

    @Test
    public void shouldBeComparable() {
        assertEquals(new Chance(1.0 / 2), new Chance(0.5));
    }

    @Test
    public void shouldCalculateTheChanceOfNotGettingATail() {
        Chance negativeOutcome = new Chance(1.0 / 2.0).not();
        assertEquals(negativeOutcome, new Chance(0.5));
    }


    @Test
    public void shouldCalculateChanceOfGettingTailsFromTwoCoins() {
        Chance firstFlip = new Chance(1.0 / 2);
        Chance secondFlip = new Chance(1.0 / 2);
        assertEquals(firstFlip.and(secondFlip), new Chance(1.0 / 4));
    }


    @Test
    public void shouldCalculateTheChanceOfGettingAtleastOneTail() {
        Chance firstFlip = new Chance(1.0 / 2);
        Chance secondFlip = new Chance(1.0 / 2);
        assertEquals(firstFlip.or(secondFlip), new Chance(3.0 / 4));
    }
}



