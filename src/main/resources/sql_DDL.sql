create schema psychology_tests;

drop TABLE answer;

drop TABLE question;

drop TABLE test;

create TYPE type_answer AS ENUM ('RADIO', 'CHECKBOX');

create TYPE role AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

create table test
(
    id_t       serial primary key,
    title_test varchar(255) not null
);

create table question
(
    id_q          serial primary key,
    test_id       int references test (id_t) not null,
    body_question varchar(255)               not null,
    type          type_answer                not null
);

create table answer
(
    id_a       serial primary key,
    question_id int references question (id_q) not null,
    answer      varchar(255)                   not null
);


create table person(
    username varchar(100) primary key,
    role role not null,
    email varchar(100)  not null,
    lastname varchar(100) not null,
    password varchar(100) not null,
    enabled boolean not null
);

insert into role (role)
values ('ROLE_ADMIN'),
        ('ROLE_USER');

insert into person (email, username, lastname, "password", enabled)
values ('qwe@mail.ru', 'garet', 'Петров', '123', 1),
        ('asd@mail.ru', 'svarog', 'Иванов',  '123', 1);

insert into test (title_test)
values ('ТЕСТИРОВАНИЕ ПЕРВОЕ ЕПТА'),
       ('ТЕСТИРОВАНИЕ ВРОТОЕ ЕПТА');

insert into question(test_id, body_question, type)
values (1, 'БД ТЕСТ 1 Вопрос 1', 'RADIO'),
       (1, 'БД ТЕСТ 1 Вопрос 2', 'CHECKBOX'),
       (1, 'БД ТЕСТ 1 Вопрос 3', 'CHECKBOX'),
       (1, 'БД ТЕСТ 1 Вопрос 4', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 1', 'CHECKBOX'),
       (2, 'БД ТЕСТ 2 Вопрос 2', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 3', 'CHECKBOX'),
       (2, 'БД ТЕСТ 2 Вопрос 4', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 5', 'CHECKBOX');

insert into answer(question_id, answer)
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

select *
from question
         left join answer pa on question.id_q = pa."question_id"
where question.id_q = 1;

select q.id_q,
       q.body_question,
       q.type,
       a.id_a,
       a.answer
from psychology_tests.question as q
         left join psychology_tests.answer as a on q.id_q = a."question_id"
where q.id_q = 1;

select t.id_t,
       t.title_test,
       q.id_q,
       q.body_question,
       q.type,
       a.id_a,
       a.answer
from test as t
         left join psychology_tests.question as q on t.id_t = q.test_id
         left join answer as a on q.id_q = a.question_id
where t.id_t = 2;

select id_q,
       body_question,
       type
from psychology_tests.question
where test_id = 1;

select username,
    password,
    enabled
from person
where username = 'garet'
















