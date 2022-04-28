package ru.shaplov.passportservice.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import ru.shaplov.passportservice.model.Passport;
import ru.shaplov.passportservice.model.persistence.PassportEntity;
import ru.shaplov.passportservice.repository.PassportRepository;
import ru.shaplov.passportservice.service.PassportService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final ModelMapper modelMapper;

    public PassportServiceImpl(PassportRepository passportRepository,
                               ModelMapper modelMapper) {
        this.passportRepository = passportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Passport save(Passport passport) {
        PassportEntity entity = modelMapper.map(passport, PassportEntity.class);
        return modelMapper.map(passportRepository.save(entity), Passport.class);
    }

    @Override
    public void update(Long id, Passport passport) {
        PassportEntity entity = modelMapper.map(passport, PassportEntity.class);
        entity.setId(id);
        passportRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        passportRepository.deleteById(id);
    }

    @Override
    public List<Passport> find(String series) {
        List<PassportEntity> allBySeries;
        if (!ObjectUtils.isEmpty(series)) {
            allBySeries = passportRepository.findAllBySeries(series);
        } else {
            allBySeries = passportRepository.findAll();
        }
        return modelMapper.map(allBySeries, new TypeToken<List<Passport>>(){}.getType());
    }

    @Override
    public List<Passport> findUnavailable() {
        List<PassportEntity> allByValidUntilBefore = passportRepository.findAllByValidUntilBefore(LocalDate.now());
        return modelMapper.map(allByValidUntilBefore, new TypeToken<List<Passport>>(){}.getType());
    }

    @Override
    public List<Passport> findReplaceable() {
        List<PassportEntity> allByValidUntilBetween = passportRepository.findAllByValidUntilBetween(
                LocalDate.now(), LocalDate.now().plus(3, ChronoUnit.MONTHS));
        return modelMapper.map(allByValidUntilBetween, new TypeToken<List<Passport>>(){}.getType());
    }
}
