package com.example.walrus.service;

import com.example.walrus.entity.Quiz;
import com.example.walrus.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {
    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }


    public Optional<Quiz> findById(Integer id_question) {
        return quizRepository.findById(id_question);
    }

}
