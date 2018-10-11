package com.example.walrus.service;

import com.example.walrus.entity.Choice;
import com.example.walrus.repository.ChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoiceService {

    private ChoiceRepository choiceRepository;

    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public List<Choice> findAll() {
        return choiceRepository.findAll();
    }

    public Optional<Choice> findById(Integer id) {
        return choiceRepository.findById(id);
    }

    public void add(Choice choice) {
        choiceRepository.save(choice);
    }
}
