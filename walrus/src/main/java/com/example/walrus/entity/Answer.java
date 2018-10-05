package com.example.walrus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
    DROP TABLE IF EXISTS Answer;
    CREATE TABLE Answer (
        -- PRIMARY KEY --
        id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
        -- OTHER --
        name VARCHAR(250) NOT NULL
    );
 */

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
