package com.phyllipesa.workshopmongo.domain.services;

import com.phyllipesa.workshopmongo.domain.entities.User;
import com.phyllipesa.workshopmongo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }
}
