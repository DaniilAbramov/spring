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

    }

}
