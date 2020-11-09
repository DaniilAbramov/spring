package hw.itsjava.dao;

import hw.itsjava.domain.Email;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("ALL")
@Repository
@AllArgsConstructor
public class EmailDaoImpl implements EmailDao {
    private final NamedParameterJdbcOperations jdbcOperations;


    @Override
    public void insert(Email email) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("EMAIL_ID", email.getId());
        mapSqlParameterSource.addValue("EMAIL", email.getEmail());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("INSERT INTO EMAILS(EMAIL) values (:EMAIL) ",
                mapSqlParameterSource, keyHolder);
        email.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Optional<Email> findById(long id) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("ID", id);
        return Optional.of(jdbcOperations.queryForObject("SELECT ID,EMAIL FROM EMAILS WHERE ID = :ID",
                objectMap, new EmailMapper()));
    }


    @Override
    public void deleteEmail(Email email) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("EMAIL", email);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("DELETE INTO EMAILS WHERE EMAIL = :EMAIL ",
                mapSqlParameterSource, keyHolder);
        email.setId(keyHolder.getKey().longValue());
    }

    private static class EmailMapper implements RowMapper<Email> {

        @Override
        public Email mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("EMAILS.ID");
            String email = resultSet.getString("EMAILS.EMAIL");
            return new Email(id, email);
        }
    }
}
