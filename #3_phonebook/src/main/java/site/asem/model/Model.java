/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model;

import site.asem.model.entities.NicknameDuplicateException;
import site.asem.model.entities.Record;

public interface Model {
    void addRecord(Record record) throws NicknameDuplicateException;
}
