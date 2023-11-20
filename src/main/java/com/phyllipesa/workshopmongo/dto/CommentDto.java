package com.phyllipesa.workshopmongo.dto;

import java.util.Date;

public record CommentDto(String text, Date date, AuthorDto author) {
}
