package com.example.walrus.exception;

public class QuestionException extends RuntimeException {

    public QuestionException(Integer id) {
        super("Could not find question " + id);
    }
}