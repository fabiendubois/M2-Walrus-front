package com.example.walrus.service;

import com.example.walrus.entity.Choice;
import com.example.walrus.entity.Question;
import com.example.walrus.repository.ChoiceRepository;
import com.example.walrus.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoiceService {

    private ChoiceRepository choiceRepository;
    private QuestionRepository questionRepository;

    public ChoiceService(ChoiceRepository choiceRepository, QuestionRepository questionRepository) {
        this.choiceRepository = choiceRepository;
        this.questionRepository = questionRepository;
    }

    public List<Choice> findAll() {
        return choiceRepository.findAll();
    }

    public Optional<Choice> findById(Integer id) {
        return choiceRepository.findById(id);
    }

    public Optional<Choice> add(Integer id_question, Choice choice) {
        return questionRepository.findById(id_question).map(question -> {
            choice.setQuestion(question);
            return choiceRepository.save(choice);
        });
    }
}
