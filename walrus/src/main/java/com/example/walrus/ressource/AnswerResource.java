package com.example.walrus.ressource;
import com.example.walrus.entity.Answer;
import com.example.walrus.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/answer")
public class AnswerResource {

    private final AnswerService answerService;

    public AnswerResource(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping()
    public List<Answer> get() {
        return answerService.getAll();
    }

    /*
    @RequestMapping(method = POST)
    public void create(@RequestBody String answer) {
        answerService.create(answer);
    }
    */

}