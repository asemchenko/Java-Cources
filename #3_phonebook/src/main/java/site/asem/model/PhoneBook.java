/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model;

import java.util.LinkedList;
import java.util.List;

public class PhoneBook {
    private List<Record> records = new LinkedList<>();

    public void addRecord(Record record) {
        records.add(record);
    }
}
