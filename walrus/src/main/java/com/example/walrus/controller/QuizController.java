package com.example.walrus.controller;

import com.example.walrus.entity.Quiz;
import com.example.walrus.service.QuizService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PutMapping("/quiz/{id}")
    public void updateById(@PathVariable Integer id, @Valid @RequestBody Quiz quizRequest) {
        // TODO : à compléter
    }

    @PostMapping("/quiz/{id}/_join")
    public void join(@PathVariable Integer id) throws Exception {
        Optional<Quiz> quiz = quizService.findById(id);

        quiz.orElseThrow(() -> new Exception()).getId();
    }
}
