package com.github.usuarios.services;

import com.github.usuarios.dtos.CreateUserDTO;
import com.github.usuarios.dtos.UserDTO;
import com.github.usuarios.exceptions.UserNotFoundException;
import com.github.usuarios.mappers.UserMapper;
import com.github.usuarios.models.User;
import com.github.usuarios.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public void createUser(CreateUserDTO createUserDto) {
    Optional<User> existedEmail = userRepository.findByEmail(createUserDto.email());

    if (existedEmail.isPresent()) throw new RuntimeException("E-mail já cadastrado");

    User user = userMapper.createUserDTOToUser(createUserDto);

    userRepository.save(user);
  }

  public UserDTO getUserById(String id) {
    User user = userRepository.findById(UUID.fromString(id)).orElseThrow(UserNotFoundException::new);

    return userMapper.userToUserDTO(user);
  }

}
