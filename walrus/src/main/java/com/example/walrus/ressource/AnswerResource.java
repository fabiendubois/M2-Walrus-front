package com.example.walrus.ressource;
import com.example.walrus.entity.Answer;
import com.example.walrus.exception.AnswerException;
import com.example.walrus.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class AnswerResource {

    private AnswerService answerService;

    public AnswerResource(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    @GetMapping("/answers/{id}")
    public Optional<Answer> findById(@PathVariable Integer id) {
        return answerService.findById(id);
        // Optional<Answer> answer = answerService.findById(id).orElseThrow(() -> new AnswerException(id));
    }

    @PostMapping("/answers")
    public void create(@RequestBody Answer answer) {
        answerService.add(answer);
    }



}