package com.example.walrus.entity;

import javax.persistence.*;

/*
    DROP TABLE IF EXISTS answer;
    CREATE TABLE answer (
        -- PRIMARY KEY --
        id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
        -- OTHER --
        name VARCHAR(250) NOT NULL
    );
 */

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
