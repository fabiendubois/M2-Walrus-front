package com.example.walrus.exception;

public class AnswerException extends RuntimeException {

    public AnswerException(Integer id) {
        super("Could not find answer " + id);
    }
}