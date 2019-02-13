/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.view;

import static site.asem.view.TextConstants.*;
/**
 * Is used to print data to standard output
 *
 * @see System#out
 */
public class ConsoleView {
    /**
     * Prints message to console without setting cursor to the next line
     *
     * @param msg message
     */
    public void print(String msg) {
        System.out.print(msg);
    }

    /**
     * Prints message to console and sets cursor to the next line
     *
     * @param msg message
     */
    public void println(String msg) {
        System.out.println(msg);
    }

    public void printWrongInputMessage(String msg) {
        // TODO implement msg printing
        println(WRONG_INPUT_MESSAGE);
    }
}
