package com.example.walrus.service;

import com.example.walrus.entity.Question;
import com.example.walrus.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(Integer id_question) {
        return questionRepository.findById(id_question);
    }

    public Question add(Question question) {
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
