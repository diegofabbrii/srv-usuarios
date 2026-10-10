package com.github.usuarios.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record UserDTO(
    UUID id,
    String name,
    String email,
    String password,
    String role,
    LocalDate createdAt,
    LocalDate updatedAt
) {}