package hw.itsjava.dao;

import hw.itsjava.domain.Email;
import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import({UserDaoImpl.class, EmailDaoImpl.class, PetDaoImpl.class})
public class UserDaoImplTest {
    @Autowired
    UserDao userDao;
    @Autowired
    EmailDao emailDao;
    @Autowired
    PetsDao petsDao;

    @Test
    @DisplayName("Колличество людей в базе")
    public void shouldCorrectCount() {
        assertEquals(userDao.count(), 3);
    }

    @Test
    @DisplayName("Поиск по ID")
    public void shouldCorrectFindById() {
        Pet pet = new Pet(4L, "olegPet");
        Email email = new Email(4L, "oleg@mail.ru");
        User oleg = new User(4L, "Oleg", email, pet);
        petsDao.insert(pet);
        emailDao.insert(email);
        userDao.insert(oleg);
        assertEquals(userDao.findById(4L), oleg);    }

    @Test
    @DisplayName("Должен корректно вставлять")
    public void shouldCorrectInsert() {
        Pet pet = new Pet(4L, "olegPet");
        Email email = new Email(4L, "oleg@mail.ru");
        User oleg = new User(4L, "Oleg", email, pet);
        petsDao.insert(pet);
        emailDao.insert(email);
        userDao.insert(oleg);
        assertEquals(userDao.findById(4L), oleg);
    }

    @Test
    @DisplayName("Должен корректно удалять")
    public void shouldCorrectDelete(){
        Pet pet = new Pet(4L, "olegPet");
        Email email = new Email(4L, "oleg@mail.ru");
        User oleg = new User(4L, "Oleg", email, pet);
        petsDao.insert(pet);
        emailDao.insert(email);
        userDao.insert(oleg);
        userDao.deletedUser(userDao.findById(1));
        assertEquals(userDao.count(),3);

    }

}
