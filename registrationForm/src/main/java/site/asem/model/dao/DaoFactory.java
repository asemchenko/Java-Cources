package site.asem.model.dao;

import java.sql.SQLException;

public interface DaoFactory {
    RecordDao createRecordDao();
}
