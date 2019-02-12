
/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 11-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem.controller;

import site.asem.ConsoleView;
import site.asem.model.Model;
import site.asem.model.OutOfRangeException;
// importing some string constants
import static site.asem.controller.ConsoleIOStringConstants.*;

import java.util.Scanner;


public class Controller {
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
                String errMsg = getErrorOutOfRangeMessage();
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
     *
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
     * Generates error message about invalid input.
     * Message tells that entered number is out of range.
     * Message based on ERROR_OUT_OF_RANGE_PATTERN.
     *
     * @return error message
     * @see ConsoleIOStringConstants#ERROR_OUT_OF_RANGE_PATTERN
     */
    private String getErrorOutOfRangeMessage() {
        return String.format(ERROR_OUT_OF_RANGE_PATTERN,
                model.getMinValue() - 1,
                model.getMaxValue() + 1);
    }

    /**
     * Generates message about current range of possible numbers.
     * CURRENT_RANGE_PATTERN is used to generate message
     *
     * @return message
     * @see ConsoleIOStringConstants#CURRENT_RANGE_PATTERN
     */
    private String getCurrentRangeMessage() {
        /*
         * model.getMinValue() - 1 and model.getMinValue() + 1
         * because current range is printed in exclusive range
         * format. For example:
         * model.getMinValue() == 0
         * model.getMinValue() == 100
         * than range looks like (-1;101)
         */
        return String.format(CURRENT_RANGE_PATTERN,
                model.getMinValue() - 1,
                model.getMaxValue() + 1);
    }

    /**
     * Generates message based on static variable STATISTIC_PATTERN.
     * Message tells about how many moves did gamer during the game.
     * In other words this function just inserts into STATISTIC_PATTERN
     *
     * @param movesCount Quantity of moves that user have done
     * @return message
     * @see ConsoleIOStringConstants#STATISTIC_PATTERN
     */
    private String getStatisticMessage(int movesCount) {
        return String.format(STATISTIC_PATTERN, movesCount);
    }
}
