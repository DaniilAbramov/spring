package hw.itsjava.dao;

import hw.itsjava.domain.UserWithPets;

public interface UserDaoJdbcWithPets {

    void insert(UserWithPets userWithPets,String pets);
}
