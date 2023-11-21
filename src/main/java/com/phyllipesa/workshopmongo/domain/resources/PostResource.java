package com.phyllipesa.workshopmongo.domain.resources;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.resources.util.URL;
import com.phyllipesa.workshopmongo.domain.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Controlador REST que lida com operações relacionadas a posts.
 */
@RestController
@RequestMapping("/posts")
public class PostResource {
  @Autowired
  private PostService postService;

  /**
   * Retorna um post pelo seu identificador único.
   *
   * @param id Identificador único do post.
   * @return Resposta ResponseEntity contendo o post encontrado ou status 404 se não encontrado.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post post = postService.findById(id);
    return ResponseEntity.ok().body(post);
  }

  /**
   * Retorna uma lista de posts que contêm um texto específico no título.
   *
   * @param text Texto a ser pesquisado no título dos posts.
   * @return Resposta ResponseEntity contendo a lista de posts correspondentes à pesquisa.
   */
  @GetMapping("/titlesearch")
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
    text = URL.decodeParam(text);
    List<Post> postList = postService.findByTitle(text);
    return ResponseEntity.ok().body(postList);
  }

  /**
   * Retorna uma lista de posts que correspondem a uma pesquisa avançada por texto, data mínima e máxima.
   *
   * @param text    Texto a ser pesquisado no título, corpo e comentários dos posts.
   * @param minDate Data mínima para a pesquisa.
   * @param maxDate Data máxima para a pesquisa.
   * @return Resposta ResponseEntity contendo a lista de posts correspondentes à pesquisa avançada.
   */
  @GetMapping("/fullsearch")
  public ResponseEntity<List<Post>> fullSearch(
      @RequestParam(value = "text", defaultValue = "") String text,
      @RequestParam(value = "minDate", defaultValue = "") String minDate,
      @RequestParam(value = "maxDate", defaultValue = "") String maxDate
  ) {
    text = URL.decodeParam(text);
    Date min = URL.convertDate(minDate, new Date(0L));
    Date max = URL.convertDate(maxDate, new Date());
    List<Post> postList = postService.fullSearch(text, min, max);
    return ResponseEntity.ok().body(postList);
  }
}
