/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 12-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class MoreLessGameTest {
    @Rule
    public final TestRule globalTimeout = Timeout.seconds(1);

    /**
     * Checks situations when user tries make move that is
     * out of range.
     * @throws OutOfRangeException
     */
    @Test(expected = OutOfRangeException.class)
    public void makeMoveArgShouldBeValid() throws OutOfRangeException {
        new MoreLessGame(0, 100).makeMove(150);
    }

    /**
     * Tests on situations when game is created with wrong
     * min and max parameters (max < min).
     */
    @Test(expected = IllegalArgumentException.class)
    public void moreLessGameInitRangeShouldBeValid() {
        new MoreLessGame(10, 0);
    }

    /**
     * Checks game moves calculation
     * @throws OutOfRangeException
     */
    @Test
    public void movesCountTest() throws OutOfRangeException {
        MoreLessGame game = new MoreLessGame(0, 100);
        int movesCount = 0;
        while (game.getLastMoveOutcome() != Model.GameMoveOutcome.WIN) {
            int nextMove = game.getCurrentMinValue()
                    + (game.getCurrentMaxValue() - game.getCurrentMinValue()) / 2;
            game.makeMove(nextMove);
            ++movesCount;
        }
        Assert.assertEquals(movesCount, game.getTotalMovesQuantity());
    }

    @Test
    public void invalidMoveShouldNotBeCounted() {
        MoreLessGame game = new MoreLessGame(0,1000);
        Assert.assertEquals(0, game.getTotalMovesQuantity());
        try {
            game.makeMove(-1);
        } catch (OutOfRangeException e) {}
        Assert.assertEquals(0, game.getTotalMovesQuantity());
    }
}
