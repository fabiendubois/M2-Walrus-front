package com.example.walrus.controller;

import com.example.walrus.entity.Choice;
import com.example.walrus.entity.Question;
import com.example.walrus.exception.ChoiceException;
import com.example.walrus.exception.QuestionException;
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
    private QuestionService questionService;

    public ChoiceController(ChoiceService choiceService, QuestionService questionService) {
        this.choiceService = choiceService;
        this.questionService = questionService;
    }

    /*
    @GetMapping("/choices")
    public List<Choice> findAll() {
        return choiceService.findAll();
    }
    */

    /*
    @GetMapping("/choices/{id}")
    public Optional<Choice> findById(@PathVariable Integer id) {
        Optional<Choice> choice = choiceService.findById(id);
        if(!choice.isPresent()) {
            throw new ChoiceException(id);
        }
        return  choice;
    }
    */

    @PostMapping("/questions/{id_question}/choices")
    public Optional<Choice> create(@PathVariable Integer id_question, @Valid @RequestBody Choice choice) {
        Question question = questionService.findById(id_question).orElseThrow(() -> new QuestionException(id_question));
        return choiceService.add(id_question, choice);
    }

    @DeleteMapping("/questions/{id_question}/choices/{id_choice}")
    public ResponseEntity<?>  deleteById(@PathVariable Integer id_question, @PathVariable Integer id_choice) {
        Question question = questionService.findById(id_question).orElseThrow(() -> new QuestionException(id_question));

        return this.choiceService.deleteById(id_choice)
                .map(_question -> ResponseEntity.ok().build()).orElseThrow(() -> new ChoiceException(id_choice));
    }
}