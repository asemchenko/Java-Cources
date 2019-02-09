/*
 * Copyright
 * Author: Andrii Semchenko
 * Last modified 09-02-2019
 * Project: more_less_game
 * License: MIT
 */

package site.asem;

public class Main {
    public static void main(String[] args) {
        Model model = new MoreLessGame(0, 100);
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(model, view);
        controller.start();
    }
}
