package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.UserCommandService;
import com.codesoom.assignment.dto.UserCreateRequest;
import com.codesoom.assignment.dto.UserResponse;
import com.codesoom.assignment.dto.UserUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserCommandService userCommandService;

    public UserController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        return userCommandService.createUser(userCreateRequest);
    }

    @PatchMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        return userCommandService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userCommandService.deleteUser(id);
    }
}
