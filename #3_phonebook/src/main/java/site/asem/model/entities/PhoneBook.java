/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model.entities;

import site.asem.model.Model;

import java.util.LinkedList;
import java.util.List;

/*
 * TODO
 *  Maybe PhoneBook should not implement Model
 *  Probably, another class that contain PhoneBook should be used
 *  for this purpose
 */
public class PhoneBook implements Model {
    private List<Record> records = new LinkedList<>();

    public void addRecord(Record record) throws NicknameDuplicateException {
        if (isNicknameOccupied(record.getNickname())) {
            throw new NicknameDuplicateException(record, "This nickname already exists");
        } else {
            records.add(record);
        }
    }

    private boolean isNicknameOccupied(String nickname) {
        for (Record r : records) {
            if (r.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
}
