/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 10-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem.model;

import java.util.Random;

/**
 * Contains all game logic
 */
public final class MoreLessGame implements Model {
    private int min;
    private int max;
    private int inventedNumber;
    private int countMoves;
    private GameMoveOutcome lastMoveOutcome = GameMoveOutcome.NO_MOVES_YET;

    /**
     * Creates a game with range [min;max]
     *
     * @param min
     * @param max
     * @throws IllegalArgumentException when min > max
     */
    public MoreLessGame(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException();
        }
        this.min = min;
        this.max = max;
        inventedNumber = generateRandomNumber(min, max);
    }

    /**
     * Generates random number from range [min;max] where
     * min and max are game parameters.
     * Each number from range has approximately equal
     * probability to be chosen.
     *
     * @param min minimal value to be generated
     * @param max maximum value to be generated
     * @return random number from range [min;max]
     */
    private int generateRandomNumber(int min, int max) {
        return Math.abs(new Random().nextInt()) % (max - min + 1) + min;
    }

    /**
     * Is used to get current minimal value of possible move
     *
     * @return min value
     */
    public int getCurrentMinValue() {
        return min;
    }

    /**
     * Is used to get current maximal value of possible move
     *
     * @return max value
     */
    public int getCurrentMaxValue() {
        return max;
    }

    /**
     * Accepts user's move and throws an exception when move is out of range
     *
     * @param move user's move
     * @throws OutOfRangeException
     */
    public void makeMove(int move) throws OutOfRangeException {
        if ((move < min) || (move > max)) {
            throw new OutOfRangeException();
        }
        ++countMoves;
        if (move == inventedNumber) {
            lastMoveOutcome = GameMoveOutcome.WIN;
        } else if (move < inventedNumber) {
            min = move + 1;
            lastMoveOutcome = GameMoveOutcome.MORE;
        } else { // move > inventedNumber
            max = move - 1;
            lastMoveOutcome = GameMoveOutcome.LESS;
        }
    }

    /**
     * @return last move outcome {@link site.asem.model.Model.GameMoveOutcome}
     */
    public GameMoveOutcome getLastMoveOutcome() {
        return lastMoveOutcome;
    }

    /**
     * Is used to get game statistic
     *
     * @return quantity of moves that user have made
     */
    public int getTotalMovesQuantity() {
        return countMoves;
    }
}
