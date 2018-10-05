package com.example.walrus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AnswerRepository {

    private static final HashMap<Integer,String> DATABASE = new HashMap<>();;

    public AnswerRepository() {
        DATABASE.put(1, "Reponse 1");
        DATABASE.put(2, "Reponse 2");
        DATABASE.put(3, "Reponse 3");
        DATABASE.put(4, "Reponse 4");
        DATABASE.put(5, "Reponse 5");
    }

    public List<String> getAll() {
        return DATABASE.values().stream().collect(Collectors.toList());
    }

    public void create(String answer) {
        DATABASE.put(DATABASE.keySet().size()+1, answer);
    }
}
