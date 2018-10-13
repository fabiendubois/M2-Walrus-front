package com.example.walrus.controller;
import com.example.walrus.entity.Answer;
import com.example.walrus.exception.AnswerException;
import com.example.walrus.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    @GetMapping("/answers/{id}")
    public Optional<Answer> findById(@PathVariable Integer id) {
        Optional<Answer> answer = answerService.findById(id);
        if(!answer.isPresent()) {
            throw new AnswerException(id);
        }
        return  answer;
    }

    @PostMapping("/questions/{id_question}/choices/{id_choice}/answers")
    public Optional<Answer> create(@PathVariable Integer id_question, @PathVariable Integer id_choice) {
        return answerService.add(id_question, id_choice);
    }
}