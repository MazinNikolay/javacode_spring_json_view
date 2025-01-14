package com.example.java_code_learn_spring_jsonview.service;

import com.example.java_code_learn_spring_jsonview.dto.UserDto;
import com.example.java_code_learn_spring_jsonview.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserDto dto);

    User updateUser(Long id, UserDto dto);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUserData(Long id);
}
