package bowling_kata;

public class Game {

    private int rolls[] = new int[20];
    private int currentRoll = 0;
    private int score = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        // Iterate 2 rolls at a time to keep track of spares and strikes
        for (int i = 0; i < rolls.length; i = i + 2) {

            score += rolls[i] + rolls[i + 1];

            // Spare case
            if ((rolls[i] + rolls[i + 1]) == 10) {
                score += rolls[i + 2];
            }
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println("Game class executed!");
    }
}
