package com.example.java_code_learn_spring_jsonview.mapper;

import com.example.java_code_learn_spring_jsonview.dto.UserDto;
import com.example.java_code_learn_spring_jsonview.model.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserMapper {
    public User mapDtoToEntity(UserDto dto) {
        return User.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail()).build();
    }
}
