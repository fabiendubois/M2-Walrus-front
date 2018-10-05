package com.example.walrus.repository;


import com.example.walrus.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepositoryItf extends JpaRepository<Answer, Long> {

    Answer findByValue(String value);

}
