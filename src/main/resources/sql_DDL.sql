create schema psychology_tests;

drop TABLE psychology_tests.answer;

drop TABLE psychology_tests.question;

drop TABLE psychology_tests.test;

create table psychology_tests.test
(
    id_t       serial primary key,
    title_test varchar(255) not null
);

create table psychology_tests.question
(
    id_q          serial primary key,
    test_id       int references psychology_tests.test (id_t) not null,
    body_question varchar(255)               not null,
    type          varchar(100)                not null
);

create table psychology_tests.answer
(
    id_a       serial primary key,
    question_id int references psychology_tests.question (id_q) not null,
    answer      varchar(255)                   not null
);

create table psychology_tests.person(
    username varchar(100) primary key,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100)  not null,
    password varchar(100) not null,
    role varchar(100) not null,
    enabled boolean not null,
    date_time timestamp not null
);

insert into psychology_tests.test (title_test)
values ('ТЕСТИРОВАНИЕ ПЕРВОЕ'),
       ('ТЕСТИРОВАНИЕ ВРОТОЕ');

insert into psychology_tests.question(test_id, body_question, type)
values (1, 'БД ТЕСТ 1 Вопрос 1', 'RADIO'),
       (1, 'БД ТЕСТ 1 Вопрос 2', 'CHECKBOX'),
       (1, 'БД ТЕСТ 1 Вопрос 3', 'CHECKBOX'),
       (1, 'БД ТЕСТ 1 Вопрос 4', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 1', 'CHECKBOX'),
       (2, 'БД ТЕСТ 2 Вопрос 2', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 3', 'CHECKBOX'),
       (2, 'БД ТЕСТ 2 Вопрос 4', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 5', 'CHECKBOX');

insert into psychology_tests.answer(question_id, answer)
values (1, 'БД Вопрос 1 ответ 1'),
       (1, 'БД Вопрос 1 ответ 2'),
       (2, 'БД Вопрос 2 ответ 1'),
       (2, 'БД Вопрос 2 ответ 2'),
       (3, 'БД Вопрос 3 ответ 1'),
       (3, 'БД Вопрос 3 ответ 2'),
       (3, 'БД Вопрос 3 ответ 3'),
       (3, 'БД Вопрос 3 ответ 4'),
       (4, 'БД Вопрос 4 ответ 1'),
       (4, 'БД Вопрос 4 ответ 2'),
       (4, 'БД Вопрос 4 ответ 3'),
       (5, 'БД ответ 1'),
       (5, 'БД ответ 2'),
       (6, 'БД ответ 1'),
       (6, 'БД ответ 2'),
       (7, 'БД ответ 1'),
       (7, 'БД ответ 2'),
       (7, 'БД ответ 3'),
       (8, 'БД ответ 1'),
       (8, 'БД ответ 2'),
       (9, 'БД ответ 1'),
       (9, 'БД ответ 2');


update psychology_tests.person set role = 'ROLE_ADMIN' where username = 'qwe'

update psychology_tests.person set enabled = false where username = 'zxc'















