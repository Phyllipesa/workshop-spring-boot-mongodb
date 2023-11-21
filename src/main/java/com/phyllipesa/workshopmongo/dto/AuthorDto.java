package com.phyllipesa.workshopmongo.dto;

import com.phyllipesa.workshopmongo.domain.entities.User;

/**
 * Data transfer object (DTO) que representa informações sobre o autor de um post.
 */
public record AuthorDto(String id, String name) {

  /**
   * Converte uma entidade de usuário para um AuthorDto.
   *
   * @param user Entidade de usuário a ser convertida.
   * @return Instância de AuthorDto representando o autor.
   */

  public static AuthorDto authorEntityToDto(User user) {
    return new AuthorDto(
        user.getId(),
        user.getName()
    );
  }
}
