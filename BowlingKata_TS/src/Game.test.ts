import { Game } from "./Game";

describe("Game class", () => {
    let game: Game;

    beforeEach(() => {
        game = new Game();
    });

    function rollMany(shotsNumber: number, pins: number) {
        for (let i = 0; i < shotsNumber; i++) {
            game.roll(pins);
        }
    }

    function rollSpare() {
        rollMany(2, 5);
    }

    function rollStrike() {
        game.roll(10);
    }

    it("plays an all zeroes game", () => {
        rollMany(20, 0);

        expect(game.score()).toBe(0);
    });

    it("plays an all ones game", () => {
        rollMany(20, 1);

        expect(game.score()).toBe(20);
    });

    it("rolls one spare", () => {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        expect(game.score()).toBe(16);
    });

    it("rolls a spare on the last frame", () => {
        rollMany(18, 0);
        rollSpare();
        game.roll(3);

        expect(game.score()).toBe(13);
    });

    it("plays an all spares game", () => {
        for (let i = 0; i < 10; i++) {
            rollSpare();
        }
        game.roll(5);

        expect(game.score()).toBe(150);
    });

    it("rolls one strike", () => {
        rollStrike();
        rollMany(2, 3);
        rollMany(16, 0);

        expect(game.score()).toBe(22);
    });

    it("rolls a strike on the last frame", () => {
        rollMany(18, 0);
        rollStrike();
        game.roll(5);
        game.roll(3);

        expect(game.score()).toBe(18);
    });

    it("plays an all strikes game", () => {
        for (let i = 0; i < 12; i++) {
            rollStrike();
        }

        expect(game.score()).toBe(300);
    });
});
