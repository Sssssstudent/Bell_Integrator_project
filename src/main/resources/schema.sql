CREATE TABLE IF NOT EXISTS Organization (
    id          BIGINT      COMMENT 'Уникальный идентификатор'  PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) COMMENT 'Имя организации'           NOT NULL,
    fullname    VARCHAR(50) COMMENT 'Полное имя организации'    NOT NULL  UNIQUE ,
    inn         BIGINT      COMMENT ''                          NOT NULL  UNIQUE ,
    kpp         BIGINT      COMMENT ''                          NOT NULL  UNIQUE ,
    address     VARCHAR(50) COMMENT 'Адрес организации'         NOT NULL,
    phone       VARCHAR(50) COMMENT 'Телефон организации'       UNIQUE ,
    is_active   BOOLEAN     COMMENT ''                          DEFAULT = FALSE

);
COMMENT ON TABLE Organization IS 'Таблица организаций';

CREATE TABLE IF NOT EXISTS Office (
    id        BIGINT      COMMENT 'Уникальный идентификатор'        PRIMARY KEY AUTO_INCREMENT,
    org_id    BIGINT      COMMENT 'Идентификатор связанный с идентификатором (id) в таблице организаций' FOREIGN KEY REFERENCES Organization (id),
    name      VARCHAR(50) COMMENT 'Название офиса'                  NOT NULL  UNIQUE ,
    address   VARCHAR(50) COMMENT 'Адрес офиса'                     NOT NULL,
    phone     VARCHAR(50) COMMENT 'Телефонный номер офиса'          UNIQUE ,
    is_active BOOLEAN     COMMENT ''                                DEFAULT = FALSE

)
COMMENT ON TABLE Office IS 'Таблица офисов';

CREATE TABLE ID NOT EXISTS 0ffice_Employee (
    office_id       BIGINT    COMMENT 'Уникальный идентификатор офиса',
    employee_id     BIGINT    COMMENT 'Уникальный идентификатор работника',

    PRIMARY KEY (office_id, employee_id),

    FOREIGN KEY (office_id) REFERENCES Office(id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
)

CREATE TABLE IF NOT EXISTS Employee (
    id              BIGINT      COMMENT 'Уникальный идентификатор'                            PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(50) COMMENT 'Имя пользователя'                                    NOT NULL,
    second_name     VARCHAR(50) COMMENT 'Фамилия пользователя',
    last_name       VARCHAR(50) COMMENT 'Второе имя/Отчество пользователя',
    position        VARCHAR(50) COMMENT 'Должность пользователя'                              NOT NULL,
    phone           VARCHAR(20) COMMENT 'Телефон пользователя'                                UNIQUE,
    citizenship_id  BIGINT      COMMENT 'Идентификатор, связывающий работника с его страной'  UNIQUE,
    FOREIGN KEY (citizenship_id) REFERENCES Country(id),
    office_id       BIGINT      COMMENT 'Идентификатор связывающий рабоника с офисом',
    FOREIGN KEY (office_id) REFERENCES Office(id),
    is_identified   BIGINT      COMMENT ''
)
COMMENT ON TABLE Employee IS 'Таблица работников';

CREATE TABLE IF NOT EXISTS Doc_employee (
    id          BIGINT    COMMENT 'Уникальный идентификатор'                              PRIMARY KEY AUTO_UNCREMENT,
    empl_id     BIGINT    COMMENT 'Связь документа с работником'                          NOT NULL,
    FOREIGN KEY (empl_id)   REFERENCES Employee(id),
    doc_number  BIGINT    COMMENT 'Номер документа работника'                             NOT NULL UNIQUE,
    doc_date    DATE      COMMENT 'Дата выдачи документа работника'                       NOT NULL,
    doc_type_id BIGINT    COMMENT 'Идентификатор, связывающий документ с типом документа' NOT NULL,
    FOREIGN KEY (doc_type_id) REFERENCES Doc_type(id)
)
COMMENT ON TABLE Doc_employee IS 'Таблица документов';

CREATE TABLE IF NOT EXISTS Doc_type (
    id        BIGINT      COMMENT 'Уникальный идентификатор'  PRIMARY KEY AUTO_INCREMENT,
    doc_type  VARCHAR(50) COMMENT 'Тип документа'             NOT NULL,
    code      VARCHAR(2)  COMMENT 'Код документа'             NOT NULL
)
COMMENT ON TABLE Doc_type IS 'Таблица типов документов';

CREATE TABLE IF NOT EXISTS Country (
    id        INTEGER      COMMENT 'Уникальный идентификатор' PRIMARY KEY AUOTO_INCREMENT,
    name      VARCHAR(50)  COMMENT 'Название страны'          UNIQUE  NOT NULL,
    code      VARCHAR(50)  COMMENT 'Код страны'               UNIQUE  NOT NULL
)
COMMENT ON TABLE Country IS 'Таблица стран';

CREATE INDEX UX_Organization_Full_Name ON Organization (full_name);
CREATE INDEX UX_Organization_INN  ON Organization (inn);
CREATE INDEX UX_Organization_KPP  ON Organization (kpp);
CREATE INDEX IX_Organization_Is_Active  ON Organization (is_active);

CREATE INDEX UX_Office_Name ON Office (name);
CREATE INDEX IX_Office_Is_Active ON Office (is_active);
CREATE INDEX IX_Office_Org_Id ON Office (org_id);

CREATE INDEX UX_Employee_First_Name ON Employee (first_name);
CREATE INDEX IX_Employee_Second_Name ON Employee (second_name);
CREATE INDEX IX_Employee_Last_Name ON Employee (last_name);
CREATE INDEX IX_Employee_Position ON Employee (position);
CREATE INDEX IX_Employee_Doc_Id ON Employee (doc_id);
CREATE INDEX IX_Employee_Citizenship_Id ON Employee (citizenship_id);
CREATE INDEX IX_Employee_Office_Id ON Employee (office_id);

CREATE INDEX UX_Doc_Employee_Doc_Number ON Doc_employee (doc_number);
CREATE INDEX IX_Doc_Employee_Doc_Date ON Doc_employee (doc_date);
CREATE INDEX IX_Doc_Employee_Doc_Type_Id ON Doc_employee (doc_type_id);

CREATE INDEX IX_Doc_Type_Doc_Type ON Doc_type (doc_type);
CREATE INDEX IX_Doc_Type_Code ON Doc_type (code);

CREATE INDEX UX_Country_Name ON Country (name);
CREATE INDEX UX_Country_Code ON Country (code);

CREATE INDEX IX_Office_Employee_Id ON Office_Employeee (employee_id);
CREATE INDEX IX_Employee_Office_Id ON Office_Employeee (office_id);





























