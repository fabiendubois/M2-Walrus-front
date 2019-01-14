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

    public Question create(Integer id, Question question) {

        Quiz quiz = this.quizService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        question.setQuiz(quiz);

        return questionRepository.save(question);
    }

    public Optional<?> deleteById(Integer id_question) {
        return questionRepository.findById(id_question)
                .map(question -> {
                    questionRepository.delete(question);
                    return question;
                });
    }
}
