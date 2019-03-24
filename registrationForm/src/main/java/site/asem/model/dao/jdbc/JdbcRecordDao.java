package site.asem.model.dao.jdbc;

import site.asem.model.dao.RecordDao;
import site.asem.model.entities.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcRecordDao implements RecordDao {
    private static final String INSERT_QUERY = "INSERT INTO Records " +
            "(firstName, lastName, patronymic, nickname, mobilePhone, email)" +
            " VALUE (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT " +
            "id, firstName, lastName, patronymic, nickname, mobilePhone, email FROM Records";
    private static final String SELECT_BY_ID_QUERY = "SELECT " +
            "(id, firstName, lastName, patronymic, nickname, mobilePhone, email) " +
            "FROM Records WHERE id=?";

    private static final String UPDATE_BY_ID_QUERY = "UPDATE Record " +
            "SET firstName=?, lastName=?, patronymic=?, nickname=?, mobilePhone=?, email=? " +
            "WHERE id=?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM Record WHERE id=?";
    private Connection connection;

    public JdbcRecordDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Record record) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            setPreparedStatementParameters(record, statement, 0);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int setPreparedStatementParameters(Record record, PreparedStatement s, int offset) {
        try {
            // TODO обязательно сделай из этого Builder
            s.setString(1 + offset, record.getFirstName());
            s.setString(2 + offset, record.getLastName());
            s.setString(3 + offset, record.getPatronymic());
            s.setString(4 + offset, record.getNickname());
            s.setString(5 + offset, record.getMobilePhone());
            s.setString(6 + offset, record.getEmail());
            return 7 + offset;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Record findById(long id) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setLong(1, id);
            return extractFromResultSet(statement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Record extractFromResultSet(ResultSet resultSet) {
        try {
            Record record = new Record();
            record.setId(resultSet.getLong("id"));
            record.setFirstName(resultSet.getString("firstName"));
            record.setLastName(resultSet.getString("lastName"));
            record.setPatronymic(resultSet.getString("patronymic"));
            record.setNickname(resultSet.getString("nickname"));
            record.setMobilePhone(resultSet.getString("mobilePhone"));
            record.setEmail(resultSet.getString("email"));
            return record;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Record> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            List<Record> records = new ArrayList<>(resultSet.getFetchSize());
            while (resultSet.next()) {
                records.add(extractFromResultSet(resultSet));
            }
            return records;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Record record) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID_QUERY)) {
            int nextIndex = setPreparedStatementParameters(record, statement, 0);
            statement.setLong(nextIndex, record.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(Record record) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
            statement.setLong(1, record.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
