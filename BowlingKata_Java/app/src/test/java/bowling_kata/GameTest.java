package bowling_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class GameTest {

    private Game game;

    @BeforeAll
    public void gameSetup() throws Exception {
        game = new Game();
    }

    @AfterEach
    public void resetGame() throws Exception {
        gameSetup();
    }

    private void rollMany(int shotsNumber, int pins) {
        for (int i = 0; i < shotsNumber; i++) {
            game.roll(pins);
        }
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
        rollMany(2, 5);
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

}
