package com.example.walrus.controller;

import com.example.walrus.entity.Answer;
import com.example.walrus.service.AnswerService;
import com.example.walrus.service.ChoiceService;
import com.example.walrus.service.QuestionService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class AnswerController {

    private AnswerService answerService;
    private ChoiceService choiceService;
    private QuestionService questionService;


    public AnswerController(AnswerService answerService, ChoiceService choiceService, QuestionService questionService) {
        this.answerService = answerService;
        this.choiceService = choiceService;
        this.questionService = questionService;
    }

    @PostMapping("/choices/{id_choice}/answers")
    public Optional<Answer> create(@PathVariable Integer id_choice, @RequestBody Answer answerRequest) throws Exception {
        return this.answerService.add(id_choice, answerRequest);
    }
}