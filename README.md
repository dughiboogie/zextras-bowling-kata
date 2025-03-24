# zextras-bowling-kata

This repository contains two projects that implement the **Bowling Kata**, one in Java and the other in Typescript.

The **Java** project was implemented using a TDD approach.

The **Typescript** project was just an adaptation of the Java one, and I made it only to refresh my memory on Typescript projects.

# Running the tests

- To run the tests for the **Java project**, execute the task `gradle test` from the command line.
- To run the tests for the **Typescript project**, execute the task `yarn test` from the command line.

# Project Specifications

## Bowling Rules

The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.

A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

## Requirements

Write a class Game that has two methods:

1. `void roll(int)` is called each time the player rolls a ball. The argument is the number of pins knocked down.

2. `int score()` returns the total score for that game.
