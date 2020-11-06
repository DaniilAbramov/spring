package hw.itsjava.dao;

import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;

public interface UserDao {

    int count();

    void insert(User user);

   User findById(long id);

   void updateEmail(User user, String newEmail);

   void deletedUser(User user);

//   void addPet(User user, Pet pet);
}
