package hw.itsjava.dao;

import hw.itsjava.domain.Email;
import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;
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

@SuppressWarnings("ALL")
@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    private final NamedParameterJdbcOperations jdbcOperations;


    @Override
    public int count() {
        return jdbcOperations.getJdbcOperations().queryForObject("select count(*) from users", Integer.class);
    }

    @Override
    public void insert(User user) {
//        jdbcOperations.update("insert into users(id,name,age) values (?,?,?) ", user.getId(), user.getName(), user.getAge());

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ID", user.getId());
        mapSqlParameterSource.addValue("NAME", user.getName());
        mapSqlParameterSource.addValue("EMAIL_ID", user.getEmail().getId());
        mapSqlParameterSource.addValue("PET_ID", user.getPet().getId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("INSERT INTO USERS(NAME,EMAIL_ID,PET_ID) values (:NAME, :EMAIL_ID,:PET_ID) ",
                mapSqlParameterSource, keyHolder);
        user.setId(keyHolder.getKey().longValue());
    }

    @Override
    public User findById(long id) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("ID", id);
        return jdbcOperations.queryForObject("select u.ID,u.NAME,e.ID,e.EMAIL,p.ID,p.NICKNAME " +
                        "from USERS as u, EMAILS as e,PETS as p where u.ID = :ID and u.EMAIL_ID = e.id and u.PET_ID = p.ID",
                objectMap, new UserMapper());
    }

    @Override
    public void updateEmail(User user, String newEmail) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ID", user.getEmail().getId());
        mapSqlParameterSource.addValue("EMAIL", newEmail);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("UPDATE EMAILS SET EMAIL = :EMAIL WHERE ID = :ID",
                mapSqlParameterSource, keyHolder);
        user.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void deleteUser(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ID", user.getId());
//        mapSqlParameterSource.addValue("EMAIL", user.getEmail().getId());
//        mapSqlParameterSource.addValue("PET", user.getPet().getId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("DELETE FROM USERS WHERE ID = :ID",
                mapSqlParameterSource, keyHolder);
        user.setId(keyHolder.getKey().longValue());
    }

//    @Override
//    public void addPet(User user, Pet pet) {
//        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//        mapSqlParameterSource.addValue("ID", user.getPet().getId());
//        mapSqlParameterSource.addValue("PET", pet);
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcOperations.update("INSERT INTO PETS SET  = :PET WHERE ID = :ID",
//                mapSqlParameterSource,keyHolder);
//        user.setId(keyHolder.getKey().longValue());
//
//    }


    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("users.ID");
            String name = resultSet.getString("users.NAME");

            Email email = new Email(resultSet.getLong("emails.ID"), resultSet.getString("emails.EMAIL"));
            Pet pet = new Pet(resultSet.getLong("pets.ID"), resultSet.getString("pets.NICKNAME"));

            return new User(id, name, email, pet);
        }
    }
}
