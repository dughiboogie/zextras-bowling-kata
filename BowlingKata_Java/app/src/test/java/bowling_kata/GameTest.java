package bowling_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class GameTest {

    private Game game;

    @BeforeEach
    public void gameSetup() throws Exception {
        game = new Game();
    }

    private void rollMany(int shotsNumber, int pins) {
        for (int i = 0; i < shotsNumber; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        rollMany(2, 5);
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Test
    public void allZeroesGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnesGame() throws Exception {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void lastFrameSpare() throws Exception {
        rollMany(18, 0);
        rollSpare();
        game.roll(3);
        assertEquals(13, game.score());
    }

    @Test
    public void allSpares() throws Exception {
        for (int i = 0; i < 10; i++) {
            rollSpare();
        }
        game.roll(5);
        assertEquals(150, game.score());
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        rollMany(2, 3);
        rollMany(16, 0);
        assertEquals(22, game.score());
    }

    @Test
    public void lastFrameStrike() throws Exception {
        rollMany(18, 0);
        rollStrike();
        game.roll(5);
        game.roll(3);
        assertEquals(18, game.score());
    }

    @Test
    public void allStrikes() throws Exception {
        for (int i = 0; i < 12; i++) {
            rollStrike();
        }
        assertEquals(300, game.score());
    }
}
