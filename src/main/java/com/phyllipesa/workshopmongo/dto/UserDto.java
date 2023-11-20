package com.phyllipesa.workshopmongo.dto;

import com.phyllipesa.workshopmongo.domain.entities.User;

public record UserDto(String id, String name, String email) {

  public static UserDto userEntityToDto(User user) {
    return new UserDto(
        user.getId(),
        user.getName(),
        user.getEmail()
    );
  }

  public static User fromDto(UserDto userDto) {
    return new User(
      userDto.id,
      userDto.name,
      userDto.email
    );
  }
}
