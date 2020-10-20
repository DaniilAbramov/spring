package ru.itsjava.dao;

import org.springframework.stereotype.Component;
import ru.itsjava.domain.Film;

@Component
public class FilmDaoSimple implements FilmDao {
    @Override
    public Film getByName(String name) {
        System.out.println("getBy name from DaoSimple");
        return new Film(name);
    }
}
