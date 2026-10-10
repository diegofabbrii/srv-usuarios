package com.github.usuarios.mappers;

import com.github.usuarios.dtos.CreateUserDTO;
import com.github.usuarios.dtos.UserDTO;
import com.github.usuarios.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(source = "name", target = "name")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "role", target = "role")
  User createUserDTOToUser(CreateUserDTO createUserDTO);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "role", target = "role")
  @Mapping(source = "createdAt", target = "createdAt")
  @Mapping(source = "updatedAt", target = "updatedAt")
  UserDTO userToUserDTO(User user);

}
