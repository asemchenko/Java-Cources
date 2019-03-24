/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model.entities;

public class NicknameDuplicateException extends Exception {
    private Record record;
    public NicknameDuplicateException(Record record, String msg) {
        super(msg);
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }
}
