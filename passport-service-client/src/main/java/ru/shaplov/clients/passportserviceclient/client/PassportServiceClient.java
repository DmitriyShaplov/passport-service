package ru.shaplov.clients.passportserviceclient.client;

import ru.shaplov.clients.passportserviceclient.model.Passport;

import java.util.List;

public interface PassportServiceClient {

    Passport save(Passport passport);

    void update(Long id, Passport passport);

    void delete(Long id);

    List<Passport> find(String series);

    List<Passport> findUnavailable();

    List<Passport> findReplaceable();
}
