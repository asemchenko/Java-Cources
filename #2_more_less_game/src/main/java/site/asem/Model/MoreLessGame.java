/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 09-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem.Model;

import java.util.Random;

/**
 * Contains all game logic
 */
public final class MoreLessGame implements Model {
    private int min;
    private int max;
    private int inventedNumber;
    private int countMoves;

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
    public int getMinValue() {
        return min;
    }

    /**
     * Is used to get current maximal value of possible move
     *
     * @return max value
     */
    public int getMaxValue() {
        return max;
    }

    /**
     * Accepts user's move and throws an exception when move is out of range
     *
     * @param move user's move
     * @return game move outcome
     * @throws OutOfRangeException
     * @see Model.GameMoveOutcome
     */
    public GameMoveOutcome makeMove(int move) throws OutOfRangeException {
        if ((move < min) || (move > max)) {
            throw new OutOfRangeException();
        }
        ++countMoves;
        if (move == inventedNumber) {
            return GameMoveOutcome.WIN;
        } else if (move < inventedNumber) {
            min = move + 1;
            return GameMoveOutcome.MORE;
        } else { // move > inventedNumber
            max = move - 1;
            return GameMoveOutcome.LESS;
        }
    }

    /**
     * Is used to get game statistic
     *
     * @return quantity of moves that user have made
     */
    public int getMovesCount() {
        return countMoves;
    }
}
