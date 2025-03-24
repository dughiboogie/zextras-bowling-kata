package bowling_kata;

public class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;
    private int score = 0;

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int normalFrameScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) { // Iterate over frames
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex++;
            }
            else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            }
            else {
                score += normalFrameScore(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println("Game class executed!");
    }
}
