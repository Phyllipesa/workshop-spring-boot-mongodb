package com.phyllipesa.workshopmongo.domain.entities;

import com.phyllipesa.workshopmongo.dto.AuthorDto;
import com.phyllipesa.workshopmongo.dto.CommentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Representa um post em um sistema de blog.
 */
@Document
public class Post {

  @Id
  private String id;
  private Date date;
  private String title;
  private String body;
  private AuthorDto author;

  private List<CommentDto> comments = new ArrayList<>();

  public Post() {
  }

  /**
   * Construtor para criar um novo post com informações específicas.
   *
   * @param id     Identificador único do post.
   * @param date   Data de publicação do post.
   * @param title  Título do post.
   * @param body   Corpo ou conteúdo do post.
   * @param author Autor do post representado como um objeto AuthorDto.
   */
  public Post(String id, Date date, String title, String body, AuthorDto author) {
    this.id = id;
    this.date = date;
    this.title = title;
    this.body = body;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public AuthorDto getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDto author) {
    this.author = author;
  }

  public List<CommentDto> getComments() {
    return comments;
  }

  public void setComments(List<CommentDto> comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Post post)) return false;
    return Objects.equals(id, post.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
