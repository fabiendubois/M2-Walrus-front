package com.example.walrus.controller;

import com.example.walrus.entity.Quiz;
import com.example.walrus.service.QuizService;
import com.example.walrus.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public List<Quiz> findAll() {
        return quizService.findAll();
    }

    @GetMapping("/quiz/{id}")
    public Quiz findById(@PathVariable Integer id) {
        return this.quizService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
    }

    @PostMapping("/quiz")
    public ResponseEntity<Quiz> create(@Valid @RequestBody Quiz quizRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.quizService.create(quizRequest));
    }


    @PostMapping("/quiz/{id}/_start")
    public void start(@PathVariable Integer id) throws Exception {
        this.quizService.start(id);
    }

    @PostMapping("/quiz/{id}/_complete")
    public void complete(@PathVariable Integer id) throws Exception {
        this.quizService.complete(id);
    }

    /*
    @PostMapping("/quiz/{id}/_join")
    public void join(@PathVariable Integer id) throws Exception {
        Optional<Quiz> quiz = quizService.findById(id);

        quiz.orElseThrow(() -> new Exception()).getId();
    }
    */
}
