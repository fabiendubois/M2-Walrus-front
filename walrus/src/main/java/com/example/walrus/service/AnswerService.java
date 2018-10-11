package com.example.walrus.service;

import com.example.walrus.entity.Answer;
import com.example.walrus.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Optional<Answer> findById(Integer id) {
        return answerRepository.findById(id);
    }

    public void add(Answer answer) {
        answerRepository.save(answer);
    }
}
