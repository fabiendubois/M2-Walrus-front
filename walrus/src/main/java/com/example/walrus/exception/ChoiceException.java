package com.example.walrus.exception;

public class ChoiceException extends RuntimeException {

    public ChoiceException(Integer id) {
        super("Could not find choice " + id);
    }
}