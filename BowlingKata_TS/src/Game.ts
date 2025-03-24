export class Game {
    private rolls: number[] = [21];
    private currentRoll: number = 0;
    private gameScore: number = 0;

    private isStrike(rollIndex: number): boolean {
        return this.rolls[rollIndex] == 10;
    }

    private isSpare(rollIndex: number): boolean {
        return this.rolls[rollIndex] + this.rolls[rollIndex + 1] == 10;
    }

    private strikeBonus(rollIndex: number): number {
        return this.rolls[rollIndex + 1] + this.rolls[rollIndex + 2];
    }

    private spareBonus(rollIndex: number): number {
        return this.rolls[rollIndex + 2];
    }

    private normalFrameScore(rollIndex: number): number {
        return this.rolls[rollIndex] + this.rolls[rollIndex + 1];
    }

    public roll(pins: number) {
        this.rolls[this.currentRoll++] = pins;
    }

    public score(): number {
        let rollIndex = 0;

        for (let frame = 0; frame < 10; frame++) { // Iterate over frames
            if (this.isStrike(rollIndex)) {
                this.gameScore += 10 + this.strikeBonus(rollIndex);
                rollIndex++;
            } else if (this.isSpare(rollIndex)) {
                this.gameScore += 10 + this.spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                this.gameScore += this.normalFrameScore(rollIndex);
                rollIndex += 2;
            }
        }
        return this.gameScore;
    }
}
