
/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 09-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem;

import java.util.Scanner;

public class Controller {
    private static final String REQUEST_FOR_MOVE_MESSAGE = "Input your move: ";
    private static final String IS_NOT_INTEGER_MESSAGE = "It's not a number!";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations!"
            + "You win!";
    private static final String LESS_MESSAGE = "Invented number is less than yours";
    private static final String MORE_MESSAGE = "Invented number is more than yours";
    /**
     * Is used to create a message about current range. It is a format parameter
     * for String.format method
     * @see java.lang.String#format(String, Object...)
     */
    private static final String CURRENT_RANGE_PATTERN = "Current range: [%d;%d]";
    /**
     * Is used to create a message about wrong input. It is a format parameter for
     * String.format
     * @see java.lang.String#format(String, Object...)
     */
    private static final String ERROR_OUT_OF_RANGE_PATTERN = "Sorry, wrong input."
            + " An integer from range [%d;%d] should be entered."
            + " Please try again.";
    /**
     * Is used to make an information message about game statistic.
     * It is a format parameter for String.format method
     * @see java.lang.String#format(String, Object...)
     */
    private static final String STATISTIC_PATTERN = "You have finished for %d moves";

    private Model model;
    private ConsoleView view;
    private Scanner scanner = new Scanner(System.in);

    public Controller(Model model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Model.GameMoveOutcome moveOutcome = null;
        while (moveOutcome != Model.GameMoveOutcome.WIN) {
            view.println(getCurrentRangeMessage());
            int move = getUsersMove();
            try {
                moveOutcome = model.makeMove(move);
            } catch (OutOfRangeException e) {
                String errMsg = String.format(ERROR_OUT_OF_RANGE_PATTERN,
                        model.getMinValue(),
                        model.getMaxValue());
                view.println(errMsg);
                continue;
            }
            if (moveOutcome == Model.GameMoveOutcome.LESS) {
                view.println(LESS_MESSAGE);
            } else if (moveOutcome == Model.GameMoveOutcome.MORE) {
                view.println(MORE_MESSAGE);
            }
        }
        view.println(CONGRATULATIONS_MESSAGE);
        view.println(getStatisticMessage(model.getMovesCount()));
    }

    /**
     * Asks user for a move and gets response.
     * If response is not a number then error message will be shown and
     * user will be asked again until valid answer will be received.
     * @return user's move
     */
    private int getUsersMove() {
        while (true) {
            view.print(REQUEST_FOR_MOVE_MESSAGE);
            String response = scanner.next();
            int move;
            try {
                move = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                view.println(IS_NOT_INTEGER_MESSAGE);
                continue;
            }
            return move;
        }
    }

    /**
     * Generates message about current range of possible numbers.
     * CURRENT_RANGE_PATTERN is used to generate message
     * @return message
     * @see site.asem.Controller#CURRENT_RANGE_PATTERN
     */
    private String getCurrentRangeMessage() {
        return String.format(CURRENT_RANGE_PATTERN,
                model.getMinValue(),
                model.getMaxValue());
    }

    /**
     * Generates message based on static variable STATISTIC_PATTERN.
     * Message tells about how many moves did gamer during the game.
     * In other words this function just inserts into STATISTIC_PATTERN
     * @param movesCount Quantity of moves that user have done
     * @return message
     * @see site.asem.Controller#STATISTIC_PATTERN
     */
    private String getStatisticMessage(int movesCount) {
        return String.format(STATISTIC_PATTERN, movesCount);
    }
}
