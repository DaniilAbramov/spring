package ru.itsjava.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.FilmDao;
import ru.itsjava.domain.Film;


@AllArgsConstructor
@Service
public class FilmService {
    private final FilmDao filmDao;

    public Film getFilm(String name) {
        return filmDao.getByName(name);
    }

}
