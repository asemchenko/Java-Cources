
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

import java.util.Scanner;

import static site.asem.controller.ConsoleIOStringConstants.*;
import static site.asem.model.Model.GameMoveOutcome.WIN;


public class Controller {
    private Model model;
    private ConsoleView view;
    private Scanner scanner = new Scanner(System.in);

    public Controller(Model model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        showWelcomeMessage();
        processMoves();
        showStatistic();
    }

    private void showStatistic() {
        view.println(getStatisticMessage(model.getTotalMovesQuantity()));
    }

    private void processMoves() {
        do {
            processOneMove();
        } while (model.getLastMoveOutcome() != WIN);
    }

    private void processOneMove() {
        try {
            showPossibleMoves();
            int move = getUsersMove();
            model.makeMove(move);
            showOutcomeMessage();
        } catch (OutOfRangeException e) {
            showErrorOutOfRangeMessage();
        }
    }

    /**
     * Asks user for a move and gets response.
     * If response is not a number then error message will be shown and
     * user will be asked again until valid answer will be received.
     *
     * @return user's move
     */
    private int getUsersMove() {
        RegexScanner regexScanner = new RegexScanner(view, scanner);
        String integerRegex = "[-+]?\\d+";
        String usersMove = regexScanner.getResponse(REQUEST_FOR_MOVE_MESSAGE,
                integerRegex,
                IS_NOT_INTEGER_MESSAGE);
        return Integer.parseInt(usersMove);
    }

    private void showWelcomeMessage() {
        view.println(WELCOME_MESSAGE);
        view.println("\n\n");
    }

    private void showErrorOutOfRangeMessage() {
        String errMsg = getErrorOutOfRangeMessage();
        view.println(errMsg);
    }

    private void showOutcomeMessage() {
        // TODO REFACTOR maybe abstract fabric better then code below
        String message;
        if (model.getLastMoveOutcome() == Model.GameMoveOutcome.LESS) {
            message = LESS_MESSAGE;
        } else if (model.getLastMoveOutcome() == Model.GameMoveOutcome.MORE) {
            message = MORE_MESSAGE;
        } else if (model.getLastMoveOutcome() == WIN) {
            message = CONGRATULATIONS_MESSAGE;
        } else {
            throw new UnsupportedOperationException("Attempt to print invalid outcome");
        }
        view.println(message);
    }

    private void showPossibleMoves() {
        view.println(getPossibleMovesRangeMessage());
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
                model.getCurrentMinValue() - 1,
                model.getCurrentMaxValue() + 1);
    }

    /**
     * Generates message about current range of possible numbers.
     * CURRENT_RANGE_PATTERN is used to generate message
     *
     * @return message
     * @see ConsoleIOStringConstants#CURRENT_RANGE_PATTERN
     */
    private String getPossibleMovesRangeMessage() {
        /*
         * model.getCurrentMinValue() - 1 and model.getCurrentMinValue() + 1
         * because current range is printed in exclusive range
         * format. For example:
         * model.getCurrentMinValue() == 0
         * model.getCurrentMinValue() == 100
         * than range looks like (-1;101)
         */
        return String.format(CURRENT_RANGE_PATTERN,
                model.getCurrentMinValue() - 1,
                model.getCurrentMaxValue() + 1);
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
