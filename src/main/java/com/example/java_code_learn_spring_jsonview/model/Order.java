package com.example.java_code_learn_spring_jsonview.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    public interface OrderSummary {}

    public interface OrderDetails extends OrderSummary {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonView(OrderSummary.class)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "product")
    @NotBlank
    @JsonView(OrderSummary.class)
    private String product;

    @Column(name = "amount")
    @NotBlank
    @JsonView(OrderSummary.class)
    private BigDecimal amount;
}
