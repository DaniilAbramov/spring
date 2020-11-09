package hw.itsjava.dao;

import hw.itsjava.domain.Email;

import java.util.Optional;

public interface EmailDao {
    void insert(Email email);
    Optional<Email> findById(long id);
    void deleteEmail(Email email);

}
