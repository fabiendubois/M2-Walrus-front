package com.example.walrus.service;

import com.example.walrus.entity.Question;
import com.example.walrus.entity.Quiz;
import com.example.walrus.exception.ResourceNotFoundException;

import com.example.walrus.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private QuizService quizService;


    public QuestionService(QuestionRepository questionRepository, QuizService quizService) {
        this.questionRepository = questionRepository;
        this.quizService = quizService;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(Integer id_question) {
        return questionRepository.findById(id_question);
    }

    public void start(Integer idQuestion) {
        Question question = this.findById(idQuestion).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + idQuestion));
        question.setStarted(true);
        questionRepository.save(question);
    }

    public void complete(Integer idQuestion) {
        Question question = this.findById(idQuestion).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + idQuestion));
        question.setStarted(false);
        questionRepository.save(question);
    }
}
