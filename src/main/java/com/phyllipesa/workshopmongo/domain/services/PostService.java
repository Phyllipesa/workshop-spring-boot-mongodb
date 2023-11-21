package com.phyllipesa.workshopmongo.domain.services;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.repository.PostRepository;
import com.phyllipesa.workshopmongo.domain.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Serviço que fornece operações relacionadas a posts.
 */
@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;

  /**
   * Retorna um post pelo seu identificador único.
   *
   * @param id Identificador único do post.
   * @return Post encontrado.
   * @throws ObjectNotFoundException se o post não for encontrado.
   */
  public Post findById(String id) {
    Optional<Post> post = postRepository.findById(id);

    if (post.isEmpty()) {
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
    return post.get();
  }

  /**
   * Retorna uma lista de posts cujo título contenha o texto fornecido.
   *
   * @param text Texto a ser pesquisado nos títulos dos posts.
   * @return Lista de posts encontrados.
   */
  public List<Post> findByTitle(String text) {
    return postRepository.searchTitle(text);
  }

  /**
   * Realiza uma pesquisa avançada por posts, considerando texto, data mínima e data máxima.
   *
   * @param text    Texto a ser pesquisado nos títulos, corpos e comentários dos posts.
   * @param minDate Data mínima para filtrar os posts.
   * @param maxDate Data máxima (até o final do dia) para filtrar os posts.
   * @return Lista de posts encontrados de acordo com os critérios de pesquisa.
   */
  public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
    maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
    return postRepository.fullSearch(text, minDate, maxDate);
  }
}
