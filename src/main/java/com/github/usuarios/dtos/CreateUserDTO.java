package com.github.usuarios.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateUserDTO(
    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail deve estar no padrão correto")
    String email,

    @NotBlank(message = "Senha é obrigatória")
    String password,

    @NotNull(message = "Role é obrigatória")
    @Pattern(regexp = "^(COSTUMER|VENDOR)$", message = "Role deve ser COSTUMER ou VENDOR")
    String role
) {
}
