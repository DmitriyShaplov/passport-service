package ru.shaplov.clients.passportserviceclient.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Passport {
    private String series;
    private String number;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfIssue;
    private String issuedLocality;
    private String authority;
    private String departmentCode;
    private String lastName;
    private String firstName;
    private String middleName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    private String birthCountry;
    private String birthCity;
    private String birthPlace;
    private String regRegion;
    private String regCity;
    private String regStreet;
    private String regHouse;
    private String regApartment;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate validUntil;
}
