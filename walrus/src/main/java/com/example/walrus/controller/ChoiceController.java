package com.example.walrus.controller;

import com.example.walrus.service.ChoiceService;
import com.example.walrus.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class ChoiceController {

    private ChoiceService choiceService;
    private QuestionService questionService;

    public ChoiceController(ChoiceService choiceService, QuestionService questionService) {
        this.choiceService = choiceService;
        this.questionService = questionService;
    }

}