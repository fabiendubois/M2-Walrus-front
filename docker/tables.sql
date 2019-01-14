DROP TABLE IF EXISTS quiz;
CREATE TABLE quiz (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    -- OTHER --
    started BOOLEAN NOT NULL DEFAULT FALSE,
    nb_users int(11) NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- OTHER --
    email VARCHAR(250),
    -- FOREIGN KEY --
    id_quiz int(11) NOT NULL,
    FOREIGN KEY (id_quiz) REFERENCES quiz(id)
);

DROP TABLE IF EXISTS question;
CREATE TABLE question (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- OTHER --
    name VARCHAR(250) NOT NULL,
    started BOOLEAN NOT NULL DEFAULT FALSE,
    -- FOREIGN KEY --
    id_quiz int(11) NOT NULL,
    FOREIGN KEY (id_quiz) REFERENCES quiz(id)
);

DROP TABLE IF EXISTS choice;
CREATE TABLE choice (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- OTHER --
    name VARCHAR(250) NOT NULL,
    -- FOREIGN KEY --
    id_question int(11) NOT NULL,
    FOREIGN KEY (id_question) REFERENCES question(id)
);

DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- OTHER ---
    text VARCHAR(250) NOT NULL,
    -- FOREIGN KEY --
    id_choice int(11) NOT NULL,
    FOREIGN KEY (id_choice) REFERENCES choice(id)
);