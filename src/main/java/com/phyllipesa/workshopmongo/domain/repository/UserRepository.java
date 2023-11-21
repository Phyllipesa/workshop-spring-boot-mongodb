package com.phyllipesa.workshopmongo.domain.repository;

import com.phyllipesa.workshopmongo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável por operações de acesso a dados relacionadas a usuários em um banco de dados MongoDB.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
