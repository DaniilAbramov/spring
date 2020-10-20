package ru.itsjava.dao;

import ru.itsjava.domain.Film;

public interface FilmDao {
    Film getByName(String name);
}
