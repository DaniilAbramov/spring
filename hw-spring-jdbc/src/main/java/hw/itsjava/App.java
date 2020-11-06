package hw.itsjava;

import hw.itsjava.dao.UserDao;
import hw.itsjava.domain.Email;
import hw.itsjava.domain.Pet;
import hw.itsjava.domain.User;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {


        var context = new SpringApplication(App.class).run();
        System.out.println("context.getBean(UserDao.class).count() = " + context.getBean(UserDao.class).count());
        UserDao userDao = context.getBean(UserDao.class);




//        System.out.println("userDao.findById(1) = " + userDao.findById(1L));
////        Console.main(args);
//
//        Pet pet = new Pet(1L,"Gurka");
//        Pet pet1 = new Pet(1L,"pech");
//        Pet pet2 = new Pet(1L,"boch");
//        Email email = new Email(1L,"nikita@mail.ru");
//        Email email1 = new Email(1L,"nik@mail.ru");
//        Email email2 = new Email(1L,"dim@mail.ru");
//        User nikita = new User(1L, "Nikita", email,pet);
//        User nik = new User(1L, "nik", email1,pet1);
//        User dim = new User(1L, "dima", email2,pet2);
//        userDao.insert(nikita);
//        userDao.insert(nik);
//        userDao.insert(dim);
//        System.out.println(nikita.getId());
//        System.out.println(nik.getId());
//        System.out.println(dim.getId());
//        System.out.println("end " + userDao.count());
//        userDao.updateEmail(userDao.findById(1),"newEmail@andrey.com");
//        Pet rat = new Pet(1L,"Riki");
//        userDao.deletedUser(userDao.findById(1L));
//        System.out.println(userDao.findById(1L));



    }

}
