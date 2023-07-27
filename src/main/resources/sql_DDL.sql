CREATE SCHEMA psychology_tests;

DROP TABLE possible_answer;

DROP TABLE question;

DROP TABLE test;

CREATE TYPE type_answer AS ENUM ('RADIO', 'CHECKBOX');

CREATE TABLE test
(
    id         SERIAL PRIMARY KEY,
    title_test VARCHAR(255) NOT NULL
);

CREATE TABLE question
(
    id            SERIAL PRIMARY KEY,
    test_id       INT REFERENCES test (id) NOT NULL,
    body_question VARCHAR(255)             NOT NULL,
    type          type_answer              NOT NULL
);

CREATE TABLE possible_answer
(
    id          SERIAL PRIMARY KEY,
    question_id INT REFERENCES question (id) NOT NULL,
    answer      VARCHAR(255)                 NOT NULL
);

INSERT INTO test (title_test)
VALUES ('ТЕСТИРОВАНИЕ ПЕРВОЕ ЕПТА'),
       ('ТЕСТИРОВАНИЕ ВРОТОЕ ЕПТА');

INSERT INTO question(test_id, body_question, type)
VALUES (1, 'БД Вопрос 1', 'RADIO'),
       (1, 'БД Вопрос 2', 'CHECKBOX'),
       (1, 'БД Вопрос 3', 'CHECKBOX'),
       (1, 'БД Вопрос 4', 'RADIO'),
       (2, 'БД Вопрос 1', 'CHECKBOX'),
       (2, 'БД Вопрос 2', 'RADIO'),
       (2, 'БД Вопрос 3', 'CHECKBOX'),
       (2, 'БД Вопрос 4', 'RADIO'),
       (2, 'БД Вопрос 5', 'CHECKBOX');

INSERT INTO possible_answer(question_id, answer)
VALUES (1, 'БД ответ 1'),
       (1, 'БД ответ 2'),
       (2, 'БД ответ 1'),
       (2, 'БД ответ 2'),
       (3, 'БД ответ 1'),
       (3, 'БД ответ 2'),
       (3, 'БД ответ 3'),
       (3, 'БД ответ 4'),
       (4, 'БД ответ 1'),
       (4, 'БД ответ 2'),
       (4, 'БД ответ 3'),
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
         LEFT JOIN possible_answer pa on question.id = pa."question_id"
WHERE question.id = 1;

SELECT q.id,
       q.body_question,
       q.type,
       pa.id,
       pa.answer
FROM psychology_tests.question AS q
         LEFT JOIN psychology_tests.possible_answer AS pa on q.id = pa."question_id"
WHERE q.id = 1;

SELECT *
FROM test AS t
         LEFT JOIN psychology_tests.question AS q on t.id = q.test_id
         LEFT JOIN possible_answer AS pa on q.id = pa.question_id
WHERE t.id = 1;


















