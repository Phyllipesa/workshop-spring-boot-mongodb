package com.phyllipesa.workshopmongo.domain.resources;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.entities.User;
import com.phyllipesa.workshopmongo.domain.services.UserService;
import com.phyllipesa.workshopmongo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controlador REST que lida com operações relacionadas a usuários.
 */
@RestController
@RequestMapping("/users")
public class UserResource {
  @Autowired
  private UserService userService;

  /**
   * Retorna uma lista de todos os usuários.
   *
   * @return Resposta ResponseEntity contendo a lista de usuários.
   */
  @GetMapping
  public ResponseEntity<List<UserDto>> findAll() {
    List<User> list = userService.findAll();
    List<UserDto> listDto = list.stream()
        .map(UserDto::userEntityToDto)
        .toList();
    return ResponseEntity.ok().body(listDto);
  }

  /**
   * Retorna um usuário pelo seu identificador único.
   *
   * @param id Identificador único do usuário.
   * @return Resposta ResponseEntity contendo o usuário encontrado ou status 404 se não encontrado.
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> findById(@PathVariable String id) {
    UserDto userDto = UserDto.userEntityToDto(userService.findById(id));
    return ResponseEntity.ok().body(userDto);
  }

  /**
   * Insere um novo usuário.
   *
   * @param userDto DTO representando os dados do usuário a ser inserido.
   * @return Resposta ResponseEntity contendo o URI do novo recurso criado.
   */
  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
    User user = UserDto.fromDto(userDto);
    user = userService.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  /**
   * Exclui um usuário pelo seu identificador único.
   *
   * @param id Identificador único do usuário a ser excluído.
   * @return Resposta ResponseEntity indicando que a operação foi realizada com sucesso.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

  /**
   * Atualiza as informações de um usuário existente.
   *
   * @param userDto DTO representando os novos dados do usuário.
   * @param id      Identificador único do usuário a ser atualizado.
   * @return Resposta ResponseEntity indicando que a operação foi realizada com sucesso.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody UserDto userDto, @PathVariable String id) {
    User user = UserDto.fromDto(userDto);
    user.setId(id);
    userService.update(user);
    return ResponseEntity.noContent().build();
  }

  /**
   * Retorna a lista de posts associados a um usuário pelo seu identificador único.
   *
   * @param id Identificador único do usuário.
   * @return Resposta ResponseEntity contendo a lista de posts associados ao usuário.
   */
  @GetMapping("/{id}/posts")
  public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
    User user = userService.findById(id);
    return ResponseEntity.ok().body(user.getPosts());
  }
}
