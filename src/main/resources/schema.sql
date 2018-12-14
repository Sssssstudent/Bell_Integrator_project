CREATE TABLE IF NOT EXISTS Organization (
    id          BIGINT        PRIMARY KEY AUTO_INCREMENT ,
    name        VARCHAR(50)            NOT NULL COMMENT 'Имя организации',
    fullname    VARCHAR(50)     NOT NULL  COMMENT 'Полное имя организации' ,
    inn         BIGINT                                NOT NULL   ,
    kpp         BIGINT                               NOT NULL   ,
    address     VARCHAR(50)          NOT NULL COMMENT 'Адрес организации',
    phone       VARCHAR(50)       COMMENT 'Телефон организации' ,
    is_active   BOOLEAN     ,
    version     INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'

);
COMMENT ON TABLE Organization IS 'Таблица организаций';

CREATE TABLE IF NOT EXISTS Office (
    id        BIGINT              PRIMARY KEY AUTO_INCREMENT ,
    org_id    BIGINT       NOT NULL COMMENT 'Идентификатор связанный с идентификатором (id) в таблице организаций',
    name      VARCHAR(50)                  NOT NULL   COMMENT 'Название офиса' ,
    address   VARCHAR(50)                      NOT NULL COMMENT 'Адрес офиса',
    phone     VARCHAR(50)         COMMENT 'Телефонный номер офиса',
    FOREIGN KEY (org_id) REFERENCES Organization (id),
    is_active BOOLEAN     ,
    version     INTEGER     NOT NULL COMMENT 'Служебное поле Hibernate'

);
COMMENT ON TABLE Office IS 'Таблица офисов';

CREATE TABLE IF NOT EXISTS Country (
    id        INTEGER       PRIMARY KEY AUTO_INCREMENT ,
    name      VARCHAR(50)              NOT NULL COMMENT 'Название страны',
    code      VARCHAR(50)                NOT NULL COMMENT 'Код страны'
);
COMMENT ON TABLE Country IS 'Таблица стран';

CREATE TABLE IF NOT EXISTS Employee (
    id              BIGINT                                  PRIMARY KEY AUTO_INCREMENT ,
    first_name      VARCHAR(50)                                     NOT NULL COMMENT 'Имя пользователя',
    second_name     VARCHAR(50) COMMENT 'Фамилия пользователя',
    last_name       VARCHAR(50) COMMENT 'Второе имя/Отчество пользователя',
    position        VARCHAR(50)                               NOT NULL COMMENT 'Должность пользователя',
    phone           VARCHAR(20)                                 COMMENT 'Телефон пользователя',
    citizenship_id  BIGINT         COMMENT 'Идентификатор, связывающий работника с его страной',
    FOREIGN KEY (citizenship_id) REFERENCES Country(id),
    is_identified   BOOLEAN      COMMENT '',
    version         INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'
);
COMMENT ON TABLE Employee IS 'Таблица работников';

CREATE TABLE IF NOT EXISTS Office_Employee (
    office_id       BIGINT    COMMENT 'Уникальный идентификатор офиса',
    employee_id     BIGINT    COMMENT 'Уникальный идентификатор работника',

    PRIMARY KEY (office_id, employee_id),

    FOREIGN KEY (office_id) REFERENCES Office(id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

CREATE TABLE IF NOT EXISTS Doc_type (
    id        BIGINT        PRIMARY KEY AUTO_INCREMENT,
    type      VARCHAR(50)              NOT NULL COMMENT 'Тип документа',
    code      VARCHAR(2)               NOT NULL COMMENT 'Код документа'
);
COMMENT ON TABLE Doc_type IS 'Таблица типов документов';

CREATE TABLE IF NOT EXISTS Doc_employee (
    id          BIGINT                                  PRIMARY KEY AUTO_INCREMENT ,
    empl_id     BIGINT                              NOT NULL COMMENT 'Связь документа с работником',
    FOREIGN KEY (empl_id)   REFERENCES Employee(id),
    doc_number  BIGINT                                 NOT NULL  COMMENT 'Номер документа работника',
    doc_date    VARCHAR(50)                            NOT NULL  COMMENT 'Дата выдачи документа работника',
    type_id     BIGINT     NOT NULL COMMENT 'Идентификатор, связывающий документ с типом документа',
    FOREIGN KEY (type_id) REFERENCES Doc_type(id)
);
COMMENT ON TABLE Doc_employee IS 'Таблица документов';

CREATE INDEX UX_Organization_Full_Name ON Organization (fullname);
CREATE INDEX UX_Organization_INN  ON Organization (inn);
CREATE INDEX UX_Organization_KPP  ON Organization (kpp);
CREATE INDEX IX_Organization_Is_Active  ON Organization (is_active);
ALTER TABLE Organization ALTER COLUMN is_active SET DEFAULT FALSE;

CREATE INDEX UX_Office_Name ON Office (name);
CREATE INDEX IX_Office_Is_Active ON Office (is_active);
CREATE INDEX IX_Office_Org_Id ON Office (org_id);
ALTER TABLE Office ALTER COLUMN is_active SET DEFAULT FALSE;

CREATE INDEX UX_Employee_First_Name ON Employee (first_name);
CREATE INDEX IX_Employee_Second_Name ON Employee (second_name);
CREATE INDEX IX_Employee_Last_Name ON Employee (last_name);
CREATE INDEX IX_Employee_Position ON Employee (position);
CREATE INDEX IX_Employee_Citizenship_Id ON Employee (citizenship_id);
ALTER TABLE Employee ALTER COLUMN is_identified SET DEFAULT FALSE;


CREATE INDEX UX_Doc_Employee_Doc_Number ON Doc_employee (doc_number);
CREATE INDEX IX_Doc_Employee_Doc_Date ON Doc_employee (doc_date);
CREATE INDEX IX_Doc_Employee_Type_Id ON Doc_employee (type_id);

CREATE INDEX IX_Doc_Type_Doc_Type ON Doc_type (type);
CREATE INDEX IX_Doc_Type_Code ON Doc_type (code);

CREATE INDEX UX_Country_Name ON Country (name);
CREATE INDEX UX_Country_Code ON Country (code);

CREATE INDEX IX_Office_Employee_Id ON Office_Employee (employee_id);
CREATE INDEX IX_Employee_Office_Id ON Office_Employee (office_id);































