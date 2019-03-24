/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model.entities;

import site.asem.model.Model;
import site.asem.model.dao.RecordDao;

import java.util.Collection;

/*
 * TODO
 *  Maybe PhoneBook should not implement Model
 *  Probably, another class that contain PhoneBook should be used
 *  for this purpose
 */
public class PhoneBook implements Model {
    private RecordDao recordDao;

    public PhoneBook(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public void addRecord(Record record) throws NicknameDuplicateException {
        if (isNicknameOccupied(record.getNickname())) {
            throw new NicknameDuplicateException(record, "This nickname already exists");
        } else {
            recordDao.create(record);
        }
    }

    @Override
    public Collection<Record> getAllRecords() {
        return recordDao.findAll();
    }

    private boolean isNicknameOccupied(String nickname) {
        for (Record r : getAllRecords()) {
            if (r.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
}
