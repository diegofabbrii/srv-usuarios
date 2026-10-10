package com.github.usuarios.controllers;

import com.github.usuarios.dtos.CreateUserDTO;
import com.github.usuarios.dtos.UserDTO;
import com.github.usuarios.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserDTO body) {
    userService.createUser(body);

    return ResponseEntity.created(null).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable("id") String id) {

    UserDTO response = userService.getUserById(id);

    return ResponseEntity.ok(response);
  }

}
