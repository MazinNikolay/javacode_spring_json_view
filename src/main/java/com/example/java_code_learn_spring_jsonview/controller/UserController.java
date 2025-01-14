package com.example.java_code_learn_spring_jsonview.controller;

import com.example.java_code_learn_spring_jsonview.dto.UserDto;
import com.example.java_code_learn_spring_jsonview.model.User;
import com.example.java_code_learn_spring_jsonview.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("app/user")
@Tag(name = "API для работы с пользователями")
public class UserController {
    private final UserService service;

    @Operation(summary = "Добавление пользователя")
    @PostMapping("")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = service.createUser(userDto);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Обновление данных пользователя")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody UserDto userDto) {
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
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получение перечня пользователей")
    @PostMapping("")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404",
                    description = "User not found")
    })
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = service.createUser(userDto);
        return ResponseEntity.ok().body(user);
    }

}
