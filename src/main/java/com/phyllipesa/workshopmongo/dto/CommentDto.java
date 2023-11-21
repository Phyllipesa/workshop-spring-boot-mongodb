package com.phyllipesa.workshopmongo.dto;

import java.util.Date;

/**
 * Data transfer object (DTO) que representa informações sobre um comentário.
 */
public record CommentDto(String text, Date date, AuthorDto author) {
}
