INSERT INTO Doc_type (id, type, code, version) VALUES (1, 'Паспорт гражданина РФ', '21', 0);
INSERT INTO Doc_type (id, type, code, version) VALUES (2, 'Загранпаспорт гражданина РФ', '22', 0);

INSERT INTO Country (id, name, code, version) VALUES (1, 'Российская Федерация', '643', 0);
INSERT INTO Country (id, name, code, version) VALUES (2, 'Греция', '520', 0);
INSERT INTO Organization (id, name, fullname, inn, kpp, address, phone, is_active, version) VALUES (1, 'Газпром', 'ООО ГазПромВладивосток', 11112222, 22221111, 'ул.Циолковского, д.21', '8-921-333-21-13', true, 0 );
INSERT INTO Organization (id, name, fullname, inn, kpp, address, phone, is_active, version) VALUES (2, 'Apple', 'ООО Apple Inc', 33334444, 44443333, 'ул.Красного знамени, д.17', '8-978-454-01-01', true, 0 );

INSERT INTO Office (id, org_id, name, address, phone, is_active, version) VALUES (1, 1, 'Main office Gazprom', 'ул.Ленина, д.6', '8-925-906-32-12', true, 0 );
INSERT INTO Office (id, org_id, name, address, phone, is_active, version) VALUES (2, 2, 'Main office Apple', 'ул.Гагарина, д.54', '8-923-730-40-91', true, 0 );

INSERT INTO Employee (id, first_name, second_name, last_name, position, phone, citizenship_id, is_identified, version) VALUES (1, 'Коля', 'Сахаров', 'Кириллович', 'HR', '8-907-234-90-87', 1, true, 0 );
INSERT INTO Employee (id, first_name, second_name, last_name, position, phone, citizenship_id, is_identified, version) VALUES (2, 'Тайсон', 'Фьюри', 'Астапович', 'Security', '8-907-333-09-09', 2, true, 0 );
INSERT INTO Employee (id, first_name, second_name, last_name, position, phone, citizenship_id, is_identified, version) VALUES (3, 'Максим', 'Стрыкало', 'Эдуардович', 'DevOps', '8-999-234-90-22', 1, true, 0 );

INSERT INTO Office_Employee (office_id, employee_id, version) VALUES (1, 1, 0);
INSERT INTO Office_Employee (office_id, employee_id, version) VALUES (1, 2, 0);
INSERT INTO Office_Employee (office_id, employee_id, version) VALUES (1, 3, 0);
INSERT INTO Office_Employee (office_id, employee_id, version) VALUES (2, 3, 0);

INSERT INTO Doc_employee (id, empl_id, doc_number, doc_date, type_id, version ) VALUES (1, 1, 11111111111, '1995-03-12', 1, 0);
INSERT INTO Doc_employee (id, empl_id, doc_number, doc_date, type_id, version) VALUES (2, 1, 121212121, '2001-03-31', 2, 0);
INSERT INTO Doc_employee (id, empl_id, doc_number, doc_date, type_id, version) VALUES (3, 2, 22222222222, '2000-09-02', 1, 0);
INSERT INTO Doc_employee (id, empl_id, doc_number, doc_date, type_id, version ) VALUES (4, 3, 55555555555, '1998-08-09', 1, 0);






