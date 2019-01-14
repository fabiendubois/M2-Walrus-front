package com.example.walrus.advice;

import com.example.walrus.exception.ChoiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChoiceAdvice {
    @ResponseBody
    @ExceptionHandler(ChoiceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String choiceAdviceNotFoundHandler(ChoiceException ex) {
        return ex.getMessage();
    }
}
