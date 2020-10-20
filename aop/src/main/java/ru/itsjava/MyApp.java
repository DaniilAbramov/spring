package ru.itsjava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.itsjava.services.FilmService;

//@ComponentScan({"ru.itsjava.ru.itsjava.dao", "ru.itsjava.services"})

@EnableAspectJAutoProxy
@ComponentScan
public class MyApp {
    public static void main(String[] args) {


        var context = new AnnotationConfigApplicationContext(MyApp.class);
        System.out.println(context.getBean(FilmService.class).getFilm("Back to the future"));

    }
}
