package com.example.walrus.service;

import com.example.walrus.entity.Answer;
import com.example.walrus.repository.AnswerRepository;
import com.example.walrus.repository.ChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private ChoiceRepository choiceRepository;

    public AnswerService(AnswerRepository answerRepository, ChoiceRepository choiceRepository) {
        this.answerRepository = answerRepository;
        this.choiceRepository = choiceRepository;
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Optional<Answer> findById(Integer id) {
        return answerRepository.findById(id);
    }

    public Optional<Answer> add(Integer id_question, Integer id_choice) {
        return choiceRepository.findById(id_choice).map(choice -> {
            Answer answer = new Answer();
            answer.setChoice(choice);
            return answerRepository.save(answer);
        });
    }

    public Optional<Answer> deleteById(Integer id) {
        return answerRepository.findById(id)
                .map(answer -> {
                    answerRepository.delete(answer);
                    return answer;
                });
    }
}
