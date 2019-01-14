package com.example.walrus.advice;

import com.example.walrus.exception.QuestionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QuestionAdvice {
    @ResponseBody
    @ExceptionHandler(QuestionException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String questionAdviceNotFoundHandler(QuestionException ex) {
        return ex.getMessage();
    }
}
