package site.asem;

public interface Model {
    enum GameMoveOutcome {MORE, LESS, WIN}
    int getMinValue();
    int getMaxValue();
    GameMoveOutcome makeMove(int move) throws OutOfRangeException;
}
