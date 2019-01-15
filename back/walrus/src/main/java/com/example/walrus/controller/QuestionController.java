package com.example.walrus.controller;

import com.example.walrus.entity.Question;
import com.example.walrus.entity.Quiz;
import com.example.walrus.exception.ResourceNotFoundException;
import com.example.walrus.service.QuestionService;
import com.example.walrus.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
            .map(Quiz::getQuestions) .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
    }


    @PostMapping("/quiz/{idQuiz}/questions/{idQuestion}/_start")
    public void start(@PathVariable Integer idQuiz, @PathVariable Integer idQuestion) {
        this.questionService.start(idQuestion);
    }

    @PostMapping("/quiz/{idQuiz}/questions/{idQuestion}/_complete")
    public void complete(@PathVariable Integer idQuiz, @PathVariable Integer idQuestion) {
        this.questionService.complete(idQuestion);
    }
}
