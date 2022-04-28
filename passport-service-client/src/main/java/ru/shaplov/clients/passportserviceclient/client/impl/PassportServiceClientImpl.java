package ru.shaplov.clients.passportserviceclient.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import ru.shaplov.clients.passportserviceclient.client.PassportServiceClient;
import ru.shaplov.clients.passportserviceclient.model.Passport;

import java.util.List;

@Service
public class PassportServiceClientImpl implements PassportServiceClient {

    private final RestTemplate restTemplate;

    public PassportServiceClientImpl(RestTemplateBuilder templateBuilder,
                                     @Value("${passports.service.url}") String passportUrl) {
        restTemplate = templateBuilder.rootUri(passportUrl).build();
    }

    @Override
    public Passport save(Passport passport) {
        return restTemplate.postForObject("/save", passport, Passport.class);
    }

    @Override
    public void update(Long id, Passport passport) {
        restTemplate.put("/update?id={id}", passport, id);
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete("/delete?id={id}", id);
    }

    @Override
    public List<Passport> find(String series) {
        String uri = ObjectUtils.isEmpty(series) ? "/find" : "/find?series=" + series;
        return getList(uri);
    }

    @Override
    public List<Passport> findUnavailable() {
        return getList("/unavailable");
    }

    @Override
    public List<Passport> findReplaceable() {
        return getList("/find-replaceable");
    }

    private List<Passport> getList(String uri) {
        return restTemplate.exchange(uri,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Passport>>() {
                        })
                .getBody();
    }
}
