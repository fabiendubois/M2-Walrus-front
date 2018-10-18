package com.example.walrus.controller;

import com.example.walrus.entity.Question;
import com.example.walrus.exception.QuestionException;
import com.example.walrus.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/questions/{id}")
    public Optional<Question> findById(@PathVariable Integer id) {
        Optional<Question> question = questionService.findById(id);
        if(!question.isPresent()) {
            throw new QuestionException(id);
        }

        return  question;
    }

    @PostMapping("/questions")
    public Question create(@Valid @RequestBody Question question) {
        return questionService.add(question);
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return this.questionService.deleteById(id)
                .map(question -> ResponseEntity.ok().build()).orElseThrow(() -> new QuestionException(id));
    }
}
