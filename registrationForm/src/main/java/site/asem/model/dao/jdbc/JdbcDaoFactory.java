package site.asem.model.dao.jdbc;

import site.asem.model.dao.DaoFactory;
import site.asem.model.dao.RecordDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class JdbcDaoFactory implements DaoFactory {
    private static final ResourceBundle db_config = ResourceBundle.getBundle("database_config");
    private static final String URL = db_config.getString("url");
    private static final String USERNAME = db_config.getString("username");
    private static final String PASSWORD = db_config.getString("password");

    private static Connection connection;
    private static JdbcDaoFactory instance;

    private JdbcDaoFactory() {
    }

    public static JdbcDaoFactory getInstance() {
        if (instance == null) {
            instance = new JdbcDaoFactory();
        }
        return instance;
    }

    @Override
    public RecordDao createRecordDao() {
        return new JdbcRecordDao(getConnection());
    }

    // FIXME непонятно кто должен закрывать connection
    private Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
