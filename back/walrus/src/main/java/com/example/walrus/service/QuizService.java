package com.example.walrus.service;

import com.example.walrus.entity.Choice;
import com.example.walrus.entity.Quiz;
import com.example.walrus.exception.ResourceNotFoundException;
import com.example.walrus.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> findById(Integer id_question) {
        return quizRepository.findById(id_question);
    }

    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void start(Integer id) {
        Quiz quiz = this.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        quiz.setStarted(true);
        quizRepository.save(quiz);
    }

    public void complete(Integer id) {
        Quiz quiz = this.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        quiz.setStarted(false);
        quizRepository.save(quiz);
    }
}
