/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 10-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem.model;

public interface Model {
    enum GameMoveOutcome {MORE, LESS, WIN, NO_MOVES_YET}

    int getCurrentMinValue();

    int getCurrentMaxValue();

    void makeMove(int move) throws OutOfRangeException;

    GameMoveOutcome getLastMoveOutcome();

    int getTotalMovesQuantity();
}
