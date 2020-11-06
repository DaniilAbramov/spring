package hw.itsjava.dao;

import hw.itsjava.domain.Email;
import hw.itsjava.domain.Pet;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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
    public void deleteEmail(Email email) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("EMAIL", email);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("DELETE INTO EMAILS WHERE EMAIL = :EMAIL ",
                mapSqlParameterSource, keyHolder);
        email.setId(keyHolder.getKey().longValue());
    }

}
