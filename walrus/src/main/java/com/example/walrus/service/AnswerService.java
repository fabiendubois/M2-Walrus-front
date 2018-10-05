package com.example.walrus.service;

import com.example.walrus.entity.Answer;
import com.example.walrus.repository.AnswerRepositoryItf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepositoryItf answerRepository;

    /* Constructor */
    public AnswerService(AnswerRepositoryItf answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    /*
    public void create(String answer) {
        answerRepository.create(answer);
    }
    */
}
