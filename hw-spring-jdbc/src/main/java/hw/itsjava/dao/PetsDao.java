package hw.itsjava.dao;

import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;

public interface PetsDao {
    void insert(Pet pet);
    void deletePet(Pet pet);
}
