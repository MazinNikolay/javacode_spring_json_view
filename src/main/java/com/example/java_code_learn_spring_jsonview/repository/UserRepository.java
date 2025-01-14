package com.example.java_code_learn_spring_jsonview.repository;

import com.example.java_code_learn_spring_jsonview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndEmail(String name, String email);
}
