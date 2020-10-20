package ru.itsjava.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@Repository
@AllArgsConstructor
public class UserDaoJdbcImpl implements UserDaoJdbc {
//    private final JdbcOperations jdbcOperations;
   private final NamedParameterJdbcOperations jdbcOperations;


    @Override
    public int count() {
        return jdbcOperations.getJdbcOperations().queryForObject("select count(*) from users", Integer.class);
    }

    @Override
    public void insert(User user) {
//        jdbcOperations.update("insert into users(id,name,age) values (?,?,?) ", user.getId(), user.getName(), user.getAge());

        final Map<String,Object> params = new HashMap<>();
        params.put("id",user.getId());
        params.put("name",user.getName());
        params.put("age",user.getAge());
        jdbcOperations.update("insert into users(id,name,age) values (:id,:name,:age) ",params);

    }

    @Override
    public User findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("ID", id);

        return jdbcOperations.queryForObject("select ID,NAME,AGE from users where ID = :ID", params, new UserMapper());
    }


    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("ID");
            String name = resultSet.getString("NAME");
            int age = resultSet.getInt("AGE");

            return new User(id, name, age);
        }
    }
}
