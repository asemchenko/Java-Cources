/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.controller;

import site.asem.view.ConsoleView;

import java.util.Scanner;

/**
 * A simple console scanner which can parse user responses
 * on requests.
 */
public class RegexScanner {
    private ConsoleView view;
    private Scanner scanner;

    /**
     * Is used to create RegexScanner that will read data from
     * scanner and transmit messages via view.
     * @param view
     * @param scanner
     */
    // TODO refactor - Maybe scanner should be created in constructor
    RegexScanner(ConsoleView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    /**
     * Asks user to input some data using request var as a prompt
     * If entered string does not match regular expression defined by regex
     * than error message is shown and user is asked to enter data again
     * until correct response is given.
     * @param request prompt
     * @param regex
     * @return user's input
     */
    String getResponse(String request, String regex) {
        while (true) {
            view.print(request);
            String response = scanner.nextLine();
            if (response.matches(regex)) {
                return response;
            } else {
                // TODO fix this
                view.printWrongInputMessage(regex);
            }
        }
    }
}
