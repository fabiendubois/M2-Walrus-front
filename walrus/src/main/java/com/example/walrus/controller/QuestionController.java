package com.example.walrus.controller;

import com.example.walrus.entity.Question;
import com.example.walrus.entity.Quiz;
import com.example.walrus.service.QuestionService;
import com.example.walrus.service.QuizService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class QuestionController {

    private QuestionService questionService;
    private QuizService quizService;

    public QuestionController(QuestionService questionService, QuizService quizService) {
        this.questionService = questionService;
        this.quizService = quizService;
    }

    @GetMapping("/quiz/{id}/questions")
    public List<Question> findById(@PathVariable Integer id) throws Exception {
        return quizService.findById(id)
            .map(Quiz::getQuestions).orElseThrow(() -> new Exception());
    }
}
