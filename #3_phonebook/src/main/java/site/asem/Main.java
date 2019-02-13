
/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem;

import site.asem.controller.Controller;
import site.asem.model.PhoneBook;
import site.asem.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Controller c = new Controller(new PhoneBook(), new ConsoleView());
        c.start();
    }
}