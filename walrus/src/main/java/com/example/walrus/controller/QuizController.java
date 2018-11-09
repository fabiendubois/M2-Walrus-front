package com.example.walrus.controller;

import com.example.walrus.entity.Quiz;
import com.example.walrus.service.QuizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz/{id}")
    public Optional<Quiz> findById(@PathVariable Integer id) {
        Optional<Quiz> quiz = quizService.findById(id);

        return quiz;
    }

}
