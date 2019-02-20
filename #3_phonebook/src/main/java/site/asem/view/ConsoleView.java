/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Is used to print data to standard output
 *
 * @see System#out
 */
public class ConsoleView {
    private TextConstants textConstants;

    public ConsoleView() {
        loadTextConstants(Locale.getDefault());
    }

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
        println(String.format(getTextConstants().WRONG_INPUT_MESSAGE_FORMAT, msg));
    }

    public TextConstants getTextConstants() {
        return textConstants;
    }

    private void loadTextConstants(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("stringConstants",
                locale);
        textConstants = new TextConstants(bundle);
    }

    public void setLocale(Locale locale) {
        loadTextConstants(locale);
    }
}
