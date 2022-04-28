--liquibase formatted sql

-- changeset shaplovdv:init-schema logicalFilePath:/
CREATE SCHEMA IF NOT EXISTS ${schemaName};

CREATE TABLE IF NOT EXISTS ${schemaName}.passports
(
    id              bigserial primary key,
    series          varchar(4) CHECK (series ~ '^(\d|\s){4}$') not null,
    number          varchar(6) CHECK (number ~ '^\d{6}$')      not null,
    date_of_issue   date                                       not null,
    issued_locality varchar(128),
    authority       varchar(128)                               not null,
    department_code varchar(7) CHECK (department_code ~ '^(\d|-){7}$'),
    last_name       varchar(64)                                not null,
    first_name      varchar(64)                                not null,
    middle_name     varchar(64)                                not null,
    date_of_birth   date                                       not null,
    birth_country   varchar(64)                                not null,
    birth_city      varchar(64)                                not null,
    birth_place     varchar(64),
    reg_region      varchar(64)                                not null,
    reg_city        varchar(64)                                not null,
    reg_street      varchar(64),
    reg_house       varchar(8),
    reg_apartment   varchar(8),
    valid_until     date
);

CREATE UNIQUE INDEX IF NOT EXISTS passports_valid_until_uidx ON ${schemaName}.passports (series, number);
CREATE INDEX IF NOT EXISTS passports_valid_until_idx ON ${schemaName}.passports (valid_until);
