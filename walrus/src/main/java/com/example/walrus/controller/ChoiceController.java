package com.example.walrus.controller;

import com.example.walrus.entity.Choice;
import com.example.walrus.exception.ChoiceException;
import com.example.walrus.service.ChoiceService;
import com.example.walrus.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class ChoiceController {

    private ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService, QuestionService questionService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/choices")
    public List<Choice> findAll() {
        return choiceService.findAll();
    }

    @GetMapping("/choices/{id}")
    public Optional<Choice> findById(@PathVariable Integer id) {
        Optional<Choice> choice = choiceService.findById(id);
        if(!choice.isPresent()) {
            throw new ChoiceException(id);
        }
        return  choice;
    }

    @PostMapping("/questions/{id}/choices")
    public Optional<Choice> create(@PathVariable Integer id, @Valid @RequestBody Choice choice) {
        return choiceService.add(id, choice);
    }

    @DeleteMapping("/choices/{id}")
    public ResponseEntity<?>  deleteById(@PathVariable Integer id_choice) {
        return this.choiceService.deleteById(id_choice)
                .map(question -> ResponseEntity.ok().build()).orElseThrow(() -> new ChoiceException(id_choice));
    }
}