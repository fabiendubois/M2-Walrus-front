package com.example.walrus.service;

import com.example.walrus.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<String> getAll() {
        return answerRepository.getAll();
    }

    public void create(String answer) {
        answerRepository.create(answer);
    }
}
