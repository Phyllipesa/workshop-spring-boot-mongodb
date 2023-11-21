package com.phyllipesa.workshopmongo.domain.services;

import com.phyllipesa.workshopmongo.domain.entities.User;
import com.phyllipesa.workshopmongo.domain.repository.UserRepository;
import com.phyllipesa.workshopmongo.domain.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço que fornece operações relacionadas a usuários.
 */
@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  /**
   * Retorna uma lista de todos os usuários.
   *
   * @return Lista de usuários.
   */
  public List<User> findAll() {
    return userRepository.findAll();
  }

  /**
   * Retorna um usuário pelo seu identificador único.
   *
   * @param id Identificador único do usuário.
   * @return Usuário encontrado.
   * @throws ObjectNotFoundException se o usuário não for encontrado.
   */
  public User findById(String id) {
    Optional<User> user = userRepository.findById(id);

    if (user.isEmpty()) {
      throw new ObjectNotFoundException("Objeto não encontrado");
    }

    return user.get();
  }

  /**
   * Insere um novo usuário.
   *
   * @param user Usuário a ser inserido.
   * @return Usuário inserido.
   */
  public User insert(User user) {
    return userRepository.insert(user);
  }

  /**
   * Exclui um usuário pelo seu identificador único.
   *
   * @param id Identificador único do usuário a ser excluído.
   * @throws ObjectNotFoundException se o usuário não for encontrado.
   */
  public void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
  }

  /**
   * Atualiza as informações de um usuário existente.
   *
   * @param user Novos dados do usuário.
   * @return Usuário atualizado.
   * @throws ObjectNotFoundException se o usuário não for encontrado.
   */
  public void update(User user) {
    User newUser = userRepository.findById(user.getId()).get();
    updateData(newUser, user);
    userRepository.save(newUser);
  }

  /**
   * Atualiza os dados de um usuário com base nos novos dados fornecidos.
   *
   * @param newUser Usuário a ser atualizado.
   * @param user    Novos dados do usuário.
   */
  private void updateData(User newUser, User user) {
    newUser.setName(user.getName());
    newUser.setEmail(user.getEmail());
  }
}
