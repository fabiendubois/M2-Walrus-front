package com.example.walrus.advice;

import com.example.walrus.exception.AnswerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AnswerAdvice {

    @ResponseBody
    @ExceptionHandler(AnswerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String answerAdviceNotFoundHandler(AnswerException ex) {
        return ex.getMessage();
    }
}
