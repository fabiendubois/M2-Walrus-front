package com.example.walrus.controller;
import com.example.walrus.entity.Answer;
import com.example.walrus.entity.Choice;
import com.example.walrus.entity.Question;
import com.example.walrus.exception.AnswerException;
import com.example.walrus.exception.ChoiceException;
import com.example.walrus.exception.QuestionException;
import com.example.walrus.service.AnswerService;
import com.example.walrus.service.ChoiceService;
import com.example.walrus.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/questions/{id_question}/choices/{id_choice}/answers")
    public Optional<Answer> create(@PathVariable Integer id_question, @PathVariable Integer id_choice) {
        Question question = questionService.findById(id_question).orElseThrow(() -> new QuestionException(id_question));

        List<Choice> listChoice = question.getChoices();
        for (Choice choice : listChoice) {
            if (choice.getId() == id_choice) {
                return answerService.add(id_question, id_choice);
            }
        }

        throw new ChoiceException(id_choice);
    }
}