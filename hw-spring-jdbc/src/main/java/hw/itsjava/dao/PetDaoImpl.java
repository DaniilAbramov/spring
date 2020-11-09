package hw.itsjava.dao;

import hw.itsjava.domain.Pet;
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
public class PetDaoImpl implements PetsDao {
    private final NamedParameterJdbcOperations jdbcOperations;


    @Override
    public void insert(Pet pet) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ID", pet.getId());
        mapSqlParameterSource.addValue("NICKNAME", pet.getNickname());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("INSERT INTO PETS(NICKNAME) values (:NICKNAME) ",
                mapSqlParameterSource, keyHolder);
        pet.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Optional<Pet> findById(long id) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("ID", id);
        return Optional.of(jdbcOperations.queryForObject("SELECT ID,NICKNAME FROM PETS WHERE ID = :ID",
                objectMap, new PetMapper()));
    }

    @Override
    public void deletePet(Pet pet) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("PET", pet);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("DELETE INTO PETS WHERE PET = :PET ",
                mapSqlParameterSource, keyHolder);
        pet.setId(keyHolder.getKey().longValue());
    }


    private static class PetMapper implements RowMapper<Pet> {

        @Override
        public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("PETS.ID");
            String nickname = resultSet.getString("PETS.NICKNAME");
            return new Pet(id, nickname);
        }
    }
}

