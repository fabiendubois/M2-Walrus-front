DROP TABLE IF EXISTS question;
CREATE TABLE question (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- OTHER --
    name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS choice;
CREATE TABLE choice (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- FOREIGN KEY --
    id_question int(11) NOT NULL,
    FOREIGN KEY (id_question) REFERENCES question(id)
);

DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
    -- PRIMARY KEY --
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- FOREIGN KEY --
    id_choice int(11) NOT NULL,
    FOREIGN KEY (id_choice) REFERENCES choice(id)
);



