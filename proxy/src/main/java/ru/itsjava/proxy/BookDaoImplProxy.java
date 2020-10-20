package ru.itsjava.proxy;

public class BookDaoImplProxy implements BookDao {
    private final BookDao bookDao = new BoolDaoImpl();

    @Override
    public String getBook(long id) {
        System.out.println("Begin");
        String res = bookDao.getBook(id);
        System.out.println("End");

        return res;
    }
}
