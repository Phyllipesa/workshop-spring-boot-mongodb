package com.phyllipesa.workshopmongo.domain.repository;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Interface responsável por operações de acesso a dados relacionadas a posts em um banco de dados MongoDB.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  /**
   * Realiza uma pesquisa por título usando uma expressão regular sem diferenciar maiúsculas e minúsculas.
   *
   * @param text Texto a ser pesquisado no título.
   * @return Lista de posts que correspondem à pesquisa.
   */
  @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);

  /**
   * Realiza uma pesquisa por título, ignorando maiúsculas e minúsculas.
   *
   * @param text Texto a ser pesquisado no título.
   * @return Lista de posts que correspondem à pesquisa.
   */
  List<Post> findByTitleContainingIgnoreCase(String text);

  /**
   * Realiza uma pesquisa avançada por texto, intervalo de datas e considerando título, corpo e comentários.
   *
   * @param text     Texto a ser pesquisado no título, corpo e comentários.
   * @param minDate  Data mínima para a pesquisa.
   * @param maxDate  Data máxima para a pesquisa.
   * @return Lista de posts que correspondem à pesquisa avançada.
   */
  @Query("{ $and: [ { date: { $gte: ?1 }  }, { date: { $lte: ?2 } }, " +
      "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, " +
      "{ 'body': { $regex: ?0, $options: 'i' } }, " +
      "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
  List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
