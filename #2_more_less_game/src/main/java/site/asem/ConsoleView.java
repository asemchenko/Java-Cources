/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 09-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem;

/**
 * Is used to print data to standard output
 * @see java.lang.System#out
 */
public class ConsoleView {
    /**
     * Prints message to console without setting cursor to the next line
     * @param msg message
     */
    public void print(String msg) {
        System.out.print(msg);
    }

    /**
     * Prints message to console and sets cursor to the next line
     * @param msg message
     */
    public void println(String msg) {
        System.out.println(msg);
    }
}
