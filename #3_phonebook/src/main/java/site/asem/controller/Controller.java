/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.controller;

import site.asem.model.PhoneBook;
import site.asem.model.Record;
import site.asem.view.ConsoleView;

import java.util.Scanner;

public class Controller {
    private PhoneBook phoneBook;
    private ConsoleView view;

    public Controller(PhoneBook phoneBook, ConsoleView view) {
        this.phoneBook = phoneBook;
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Record record = new RecordInputter(view, scanner).inputRecord();
        phoneBook.addRecord(record);
    }
}
