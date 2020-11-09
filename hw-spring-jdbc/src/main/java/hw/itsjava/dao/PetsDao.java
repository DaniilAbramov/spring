package hw.itsjava.dao;

import hw.itsjava.domain.Pet;

import java.util.Optional;

public interface PetsDao {
    void insert(Pet pet);

    Optional<Pet> findById(long id);

    void deletePet(Pet pet);
}
