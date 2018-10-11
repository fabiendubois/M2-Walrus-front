package com.example.walrus.ressource;

import com.example.walrus.entity.Question;
import com.example.walrus.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class QuestionResource {

    private QuestionService questionService;

    public QuestionResource(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/questions/{id}")
    public Optional<Question> findById(@PathVariable Integer id) {
        Optional<Question> question = questionService.findById(id);

        return  question;
    }

    @PostMapping("/questions")
    public void create(@RequestBody Question question) {
        questionService.add(question);
    }
}
