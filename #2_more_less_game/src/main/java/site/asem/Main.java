/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 11-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem;

import site.asem.controller.Controller;
import site.asem.model.Model;
import site.asem.model.MoreLessGame;

public class Main {
    public static void main(String[] args) {
        Model model = new MoreLessGame(1, 99);
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(model, view);
        controller.start();
    }
}
