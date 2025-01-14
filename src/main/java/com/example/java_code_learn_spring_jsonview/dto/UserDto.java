package com.example.java_code_learn_spring_jsonview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    @Schema(description = "Имя пользователя", minLength = 2)
    private String userName;

    @Schema(description = "Email", example = "*@*.*")
    private String email;
}