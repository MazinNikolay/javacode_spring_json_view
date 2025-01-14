package com.example.java_code_learn_spring_jsonview.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    public interface UserSummary {}
    public interface UserDetails extends UserSummary {}

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserSummary.class)
    private Long userId;

    @Column(name = "user_name")
    @NotBlank
    @JsonView(UserSummary.class)
    private String userName;

    @Column(name = "email")
    @NotBlank
    @Email
    @JsonView(UserSummary.class)
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonView(UserDetails.class)
    private List<Order> orders;
}
