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
    content VARCHAR(250) NOT NULL,
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
    content VARCHAR(250) NOT NULL,
    -- FOREIGN KEY --
    id_question int(11) NOT NULL,
    FOREIGN KEY (id_question) REFERENCES question(id)
);

DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- OTHER ---
    content VARCHAR(250) NOT NULL,
    -- FOREIGN KEY --
    id_choice int(11) NOT NULL,
    FOREIGN KEY (id_choice) REFERENCES choice(id)
);

INSERT INTO quiz (started, name, nb_users) 
VALUES 
(false, 'Quiz du futur', 1);

INSERT INTO question (content, started, id_quiz) 
VALUES 
('Croyez-vous qu’il sera possible un jour de connaître l’avenir, de modifier le passé ?', false, 1),
('Voudriez-vous un jour voyager à travers une faille temporelle et retourner à l’époque où le LOSC était en Ligue 1 ?', false, 1),
('Quel prix seriez-vous prêt à débourser pour discuter avec vos ancêtres ?', false, 1),
('Quelle est la raison principale pour laquelle ce genre de technologie doit voir le jour ?', false, 1),
('Donner le mot qui résume pour vous cette technologie.', false, 1);

INSERT INTO choice (content, id_question)
VALUES
('Oui',1),
('Non',1),
('Oui',2),
('Non',2),
('10 B',3),
('100 B',3),
('1000 B',3),
('Innovation',4),
('Gagner la guerre',4),
('Gagner au loto',4),
('Connaitre son avenir',4),
('Corriger le passé',4),
('Libre', 5);