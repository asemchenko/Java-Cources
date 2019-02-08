/*
 * Author: Andrii Semchenko
 * Created at Feb 2019
 */
package site.asem;

import java.lang.System;

/**
 * Is used to output strings to System.out
 *
 * @see java.lang.System#out System.out
 */
public class View {
    /**
     * Prints string to standard output stream
     * @param msg text that needs to be printed
     */
    public void printRequest(String msg) {
        System.out.print(msg);
    }

    /**
     * Prints a message and then puts cursor in a new line
     * @param msg message
     */
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
