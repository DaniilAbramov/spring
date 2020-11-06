package hw.itsjava.dao;

import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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
    public void deletePet(Pet pet) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("PET", pet);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("DELETE INTO PETS WHERE PET = :PET ",
                mapSqlParameterSource, keyHolder);
        pet.setId(keyHolder.getKey().longValue());
    }


}

