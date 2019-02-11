/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 11-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem;

public class ConsoleIOStringConstants {
    public static final String REQUEST_FOR_MOVE_MESSAGE = "Input your move: ";
    public static final String IS_NOT_INTEGER_MESSAGE = "It's not a number!";
    public static final String CONGRATULATIONS_MESSAGE = "Congratulations!"
            + "You win!";
    public static final String LESS_MESSAGE = "Invented number is less than yours";
    public static final String MORE_MESSAGE = "Invented number is more than yours";
    /**
     * Is used to create a message about current range. It is a format parameter
     * for String.format method
     *
     * @see java.lang.String#format(String, Object...)
     */
    public static final String CURRENT_RANGE_PATTERN = "Current range: (%d;%d)";
    /**
     * Is used to create a message about wrong input. It is a format parameter for
     * String.format
     *
     * @see java.lang.String#format(String, Object...)
     */
    public static final String ERROR_OUT_OF_RANGE_PATTERN = "Sorry, wrong input."
            + " An integer from range (%d;%d) should be entered."
            + " Please try again.";
    /**
     * Is used to make an information message about game statistic.
     * It is a format parameter for String.format method
     *
     * @see java.lang.String#format(String, Object...)
     */
    public static final String STATISTIC_PATTERN = "You have finished for %d moves";
}
