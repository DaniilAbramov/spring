package hw.itsjava.dao;

import hw.itsjava.domain.UserWithPets;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@AllArgsConstructor
public class UserDaoJdbcWithPetsImpl implements UserDaoJdbcWithPets {
    private final NamedParameterJdbcOperations jdbcOperations;


    @Override
    public void insert(UserWithPets userWithPets, String pets) {
        final Map<String, Object> obj = new HashMap<>();
        obj.put("id", userWithPets.getId());
        obj.put("name", userWithPets.getName());
        obj.put("mail", userWithPets.getMail());
        obj.put("pets", userWithPets.getPets());
        jdbcOperations.update("insert into userwithpets(id,name,mail,pets) values (:id,:name,:mail,:pets) ", obj);

    }
}
