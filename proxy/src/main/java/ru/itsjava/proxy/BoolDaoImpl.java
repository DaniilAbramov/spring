package ru.itsjava.proxy;

public class BoolDaoImpl implements BookDao {

    @Override
    public String getBook(long id) {
        return "Book with id " + id;
    }
}
