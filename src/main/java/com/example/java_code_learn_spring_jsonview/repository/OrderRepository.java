package com.example.java_code_learn_spring_jsonview.repository;

import com.example.java_code_learn_spring_jsonview.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
