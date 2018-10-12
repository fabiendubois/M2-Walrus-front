package com.example.walrus.ressource;

import com.example.walrus.entity.Choice;
import com.example.walrus.service.ChoiceService;
import com.example.walrus.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class ChoiceRessource {

    private ChoiceService choiceService;


    public ChoiceRessource(ChoiceService choiceService, QuestionService questionService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/choices")
    public List<Choice> findAll() {
        return choiceService.findAll();
    }

    @GetMapping("/choices/{id}")
    public Optional<Choice> findById(@PathVariable Integer id) {
        Optional<Choice> choice = choiceService.findById(id);
        return  choice;
    }

    @PostMapping("/questions/{id}/choices")
    public Optional<Choice> create(@PathVariable Integer id, @RequestBody Choice choice) {
        return choiceService.add(id, choice);
                // .orElseThrow(()->new NotFo);
    }

}
