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

import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private Model model;
    private ConsoleView view;
    private Scanner scanner;
    private Locale locale = Locale.getDefault();

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

    public void setLocale(Locale locale) {
        this.locale = locale;
        view.setLocale(this.locale);
    }

    private void addNewRecord() {
        RecordInputter recordInputter = new RecordInputter(view, scanner, locale);
        Record record = recordInputter.inputRecord();
        do {
            try {
                model.addRecord(record);
                return;
            } catch (NicknameDuplicateException e) {
                Record caughtRecord = e.getRecord();
                view.println(caughtRecord.toString());
                view.println(view.getTextConstants().SORRY_OCCUPIED_NICKNAME);
                record = recordInputter.reinputNickname(caughtRecord);
            }
        } while (true);
    }
}
