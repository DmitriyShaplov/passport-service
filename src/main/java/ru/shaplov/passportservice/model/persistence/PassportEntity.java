package ru.shaplov.passportservice.model.persistence;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "passports")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "issued_locality")
    private String issuedLocality;

    @Column(name = "authority")
    private String authority;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "birth_country")
    private String birthCountry;

    @Column(name = "birth_city")
    private String birthCity;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "reg_region")
    private String regRegion;

    @Column(name = "reg_city")
    private String regCity;

    @Column(name = "reg_street")
    private String regStreet;

    @Column(name = "reg_house")
    private String regHouse;

    @Column(name = "reg_apartment")
    private String regApartment;

    @Column(name = "valid_until")
    private LocalDate validUntil;
}
