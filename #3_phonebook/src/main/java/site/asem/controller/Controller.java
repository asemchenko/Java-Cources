/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.controller;

import site.asem.model.Model;
import site.asem.model.entities.NicknameDuplicateException;
import site.asem.model.entities.PhoneBook;
import site.asem.model.entities.Record;
import site.asem.view.ConsoleView;
import site.asem.view.TextConstants;

import java.util.Scanner;

public class Controller {
    private Model model;
    private ConsoleView view;
    private Scanner scanner;

    public Controller(PhoneBook model, ConsoleView view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            addNewRecord();
            view.println("=================================");
        }
    }

    private void addNewRecord() {
        RecordInputter recordInputter = new RecordInputter(view, scanner);
        Record record = recordInputter.inputRecord();
        do {
            try {
                model.addRecord(record);
                return;
            } catch (NicknameDuplicateException e) {
                view.println(TextConstants.SORRY_OCCUPIED_NICKNAME);
                record = recordInputter.reinputNickname(record);
            }
        } while (true);
    }
}
