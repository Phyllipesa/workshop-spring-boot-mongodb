package com.phyllipesa.workshopmongo.dto;

import com.phyllipesa.workshopmongo.domain.entities.User;

/**
 * Data transfer object (DTO) que representa informações sobre um usuário.
 */
public record UserDto(String id, String name, String email) {

  /**
   * Converte uma entidade de usuário para um UserDto.
   *
   * @param user Entidade de usuário a ser convertida.
   * @return Instância de UserDto representando o usuário.
   */
  public static UserDto userEntityToDto(User user) {
    return new UserDto(
        user.getId(),
        user.getName(),
        user.getEmail()
    );
  }

  /**
   * Converte um UserDto para uma entidade de usuário.
   *
   * @param userDto UserDto a ser convertido.
   * @return Instância de User representando o usuário.
   */
  public static User fromDto(UserDto userDto) {
    return new User(
      null,
      userDto.name,
      userDto.email
    );
  }
}
