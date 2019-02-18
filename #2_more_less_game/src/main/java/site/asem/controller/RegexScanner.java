/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 18-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem.controller;

import site.asem.ConsoleView;

import java.util.Scanner;

/**
 * A simple console scanner which can parse valid user responses
 * on requests. Response format should be defined using regular expression.
 */
class RegexScanner {
    private ConsoleView view;
    private Scanner scanner;

    RegexScanner(ConsoleView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    /**
     * Asks user to input some data using request var as a prompt
     * If entered string does not match regular expression defined by regex
     * than error message is shown and user is asked to enter data again
     * until correct response is given.
     *
     * @param request                 prompt
     * @param regex                   regular expression
     * @param whenDoesNotMatchMessage message to be printed when invalid input is entered
     * @return user's input
     */
    String getResponse(String request, String regex, String whenDoesNotMatchMessage) {
        while (true) {
            view.print(request);
            String response = scanner.nextLine();
            if (response.matches(regex)) {
                return response;
            } else {
                view.println(whenDoesNotMatchMessage);
            }
        }
    }
}
