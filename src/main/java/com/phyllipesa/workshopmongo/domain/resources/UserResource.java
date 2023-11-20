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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDto>> findAll() {
    List<User> list = userService.findAll();
    List<UserDto> listDto = list.stream()
        .map(UserDto::userEntityToDto)
        .toList();
    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> findById(@PathVariable String id) {
    UserDto userDto = UserDto.userEntityToDto(userService.findById(id));
    return ResponseEntity.ok().body(userDto);
  }

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
    User user = UserDto.fromDto(userDto);
    user = userService.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody UserDto userDto, @PathVariable String id) {
    User user = UserDto.fromDto(userDto);
    user.setId(id);
    userService.update(user);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}/posts")
  public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
    User user = userService.findById(id);
    return ResponseEntity.ok().body(user.getPosts());
  }
}
