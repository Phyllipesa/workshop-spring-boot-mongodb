package com.phyllipesa.workshopmongo.dto;

import com.phyllipesa.workshopmongo.domain.entities.User;

public record AuthorDto(String id, String name) {

  public static AuthorDto authorEntityToDto(User user) {
    return new AuthorDto(
        user.getId(),
        user.getName()
    );
  }
}
