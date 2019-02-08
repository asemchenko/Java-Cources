package site.asem;

import java.util.Random;

public final class MoreLessGame implements Model {
    private int min;
    private int max;
    private int inventedNumber;
    private int countMoves;

    public MoreLessGame(int min, int max) {
        this.min = min;
        this.max = max;
        inventedNumber = new Random().nextInt() % (max - min + 1) + min;
    }

    public int getMinValue() {
        return min;
    }

    public int getMaxValue() {
        return max;
    }

    public GameMoveOutcome makeMove(int move) throws OutOfRangeException {
        if ( (move < min) || (move > max) ) {
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
}
