package com.example.walrus.repository;

import com.example.walrus.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Quiz, Integer> {
}
