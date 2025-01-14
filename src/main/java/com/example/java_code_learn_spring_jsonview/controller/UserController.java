package com.example.java_code_learn_spring_jsonview.controller;

import com.example.java_code_learn_spring_jsonview.dto.UserDto;
import com.example.java_code_learn_spring_jsonview.model.User;
import com.example.java_code_learn_spring_jsonview.service.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/user/")
@Tag(name = "API для работы с пользователями")
public class UserController {
    private final UserServiceImpl service;

    @Operation(summary = "Добавление пользователя")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    @JsonView(User.UserSummary.class)
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) {
        User user = service.createUser(userDto);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Обновление данных пользователя")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    @JsonView(User.UserSummary.class)
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @Valid @RequestBody UserDto userDto) {
        User user = service.updateUser(id, userDto);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    @JsonView(User.UserSummary.class)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получение перечня пользователей")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    @JsonView(User.UserSummary.class)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(service.getAllUsers());
    }

    @Operation(summary = "Получение детальной информации о пользователе")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    @JsonView(User.UserDetails.class)
    public ResponseEntity<User> getUserData(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getUserData(id));
    }
}
