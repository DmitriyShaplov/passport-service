package ru.shaplov.passportservice.service;

import ru.shaplov.passportservice.model.Passport;

import java.util.List;

public interface PassportService {
    Passport save(Passport passport);
    void update(Long id, Passport passport);
    void delete(Long id);
    List<Passport> find(String series);
    List<Passport> findUnavailable();
    List<Passport> findReplaceable();
}
