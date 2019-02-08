/*
 * Author: Andrii Semchenko
 * Created at Feb 2019
 */
package site.asem;

import java.util.Scanner;

public class Controller {
    private static final String FIRST_PART_REGEX = "Hello";
    private static final String SECOND_PART_REGEX = "world!";
    private static final String REQUEST = "Input text: ";
    private static final String ERROR_MESSAGE = "Wrong input! Try again.";
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Gets user's input and creates a sentence from it. Entered two strings
     * must be valid (match corresponding regular expression)
     */
    public void processUser() {
        String firstPart = getUsersResponse(REQUEST, FIRST_PART_REGEX);
        String secondPart = getUsersResponse(REQUEST, SECOND_PART_REGEX);
        model.append(firstPart);
        model.append(secondPart);
        String sentence = model.getSentence();
        view.printMessage(sentence);
    }

    /**
     * Shows to user request and then gets any input
     *
     * @param request request
     * @return user's response
     */
    private String getUsersResponse(String request) {
        view.printRequest(request);
        String response = new Scanner(System.in).next();
        return response;
    }

    /**
     * Shows to user request and then checks if user's
     * input matches regular expression. If response
     * does not match, then shows error message and
     * asks user for response again until right response
     * will be given.
     *
     * @param request text of the request
     * @param regex   regular expression
     * @return user's response
     */
    private String getUsersResponse(String request, String regex) {
        while (true) {
            String response = getUsersResponse(request);
            if (response.matches(regex)) {
                return response;
            }
            view.printMessage(ERROR_MESSAGE);
        }
    }
}
