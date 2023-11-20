package com.phyllipesa.workshopmongo.domain.resources;

import com.phyllipesa.workshopmongo.domain.entities.User;
import com.phyllipesa.workshopmongo.domain.services.UserService;
import com.phyllipesa.workshopmongo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
