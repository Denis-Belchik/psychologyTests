CREATE SCHEMA psychology_tests;

DROP TABLE answer;

DROP TABLE question;

DROP TABLE test;

CREATE TYPE type_answer AS ENUM ('RADIO', 'CHECKBOX');

CREATE TABLE test
(
    id_t       SERIAL PRIMARY KEY,
    title_test VARCHAR(255) NOT NULL
);

CREATE TABLE question
(
    id_q          SERIAL PRIMARY KEY,
    test_id       INT REFERENCES test (id_t) NOT NULL,
    body_question VARCHAR(255)               NOT NULL,
    type          type_answer                NOT NULL
);

CREATE TABLE answer
(
    id_a       SERIAL PRIMARY KEY,
    question_id INT REFERENCES question (id_q) NOT NULL,
--     position    INT                            NOT NULL,
    answer      VARCHAR(255)                   NOT NULL
);

INSERT INTO test (title_test)
VALUES ('ТЕСТИРОВАНИЕ ПЕРВОЕ ЕПТА'),
       ('ТЕСТИРОВАНИЕ ВРОТОЕ ЕПТА');

INSERT INTO question(test_id, body_question, type)
VALUES (1, 'БД ТЕСТ 1 Вопрос 1', 'RADIO'),
       (1, 'БД ТЕСТ 1 Вопрос 2', 'CHECKBOX'),
       (1, 'БД ТЕСТ 1 Вопрос 3', 'CHECKBOX'),
       (1, 'БД ТЕСТ 1 Вопрос 4', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 1', 'CHECKBOX'),
       (2, 'БД ТЕСТ 2 Вопрос 2', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 3', 'CHECKBOX'),
       (2, 'БД ТЕСТ 2 Вопрос 4', 'RADIO'),
       (2, 'БД ТЕСТ 2 Вопрос 5', 'CHECKBOX');

INSERT INTO answer(question_id, answer)
VALUES (1, 'БД Вопрос 1 ответ 1'),
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

SELECT *
FROM question
         LEFT JOIN answer pa on question.id_q = pa."question_id"
WHERE question.id_q = 1;

SELECT q.id_q,
       q.body_question,
       q.type,
       a.id_a,
       a.answer
FROM psychology_tests.question AS q
         LEFT JOIN psychology_tests.answer AS a on q.id_q = a."question_id"
WHERE q.id_q = 1;

SELECT t.id_t,
       t.title_test,
       q.id_q,
       q.body_question,
       q.type,
       a.id_a,
       a.answer
FROM test AS t
         LEFT JOIN psychology_tests.question AS q on t.id_t = q.test_id
         LEFT JOIN answer AS a on q.id_q = a.question_id
WHERE t.id_t = 2;

SELECT id_q,
       body_question,
       type
FROM psychology_tests.question
WHERE test_id = 1;


















