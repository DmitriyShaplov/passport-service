package ru.shaplov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaplov.passportservice.model.persistence.PassportEntity;

import java.time.LocalDate;
import java.util.List;

public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
    List<PassportEntity> findAllBySeries(String series);
    List<PassportEntity> findAllByValidUntilBefore(LocalDate date);
    List<PassportEntity> findAllByValidUntilBetween(LocalDate start, LocalDate end);
}
