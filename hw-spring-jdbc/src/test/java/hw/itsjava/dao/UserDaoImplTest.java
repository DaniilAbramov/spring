package hw.itsjava.dao;

import hw.itsjava.domain.Email;
import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

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
    public void shouldCorrectCount(){
        assertEquals(userDao.count(),3);
    }

    @Test
    @DisplayName("Поиск по ID")
    public void shouldCorrectFindById(){
        Pet pet = new Pet(1L,"olegPet");
        Email email = new Email(1L,"oleg@mail.ru");
        User oleg = new User(1L,"Oleg",email,pet);
        assertEquals(userDao.findById(4),oleg);
    }

}
