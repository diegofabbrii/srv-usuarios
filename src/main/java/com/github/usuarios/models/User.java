package com.github.usuarios.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


@Table(name = "tb_users")
@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String role;

  @Column(nullable = false)
  private LocalDate createdAt = LocalDate.now();

  @Column(nullable = true)
  private String updatedAt = null;

}
