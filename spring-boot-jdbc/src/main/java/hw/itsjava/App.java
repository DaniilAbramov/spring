package hw.itsjava;

import hw.itsjava.dao.UserDaoJdbcWithPets;
import hw.itsjava.domain.UserWithPets;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.Application;

import java.sql.SQLException;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {

       var context = new SpringApplication(Application.class).run();
//        Console.main(args);
        UserDaoJdbcWithPets userDaoJdbcWithPets = context.getBean(UserDaoJdbcWithPets.class);

        UserWithPets andrey = new UserWithPets(1, "Andrey", "and@mail.ru", "Dog");

        userDaoJdbcWithPets.insert(andrey, "Sneak");
        UserWithPets nikita = new UserWithPets(4, "Nikita", "nik@mail.ru", "Sneak");


    }

}
