package com.phyllipesa.workshopmongo.domain.repository;

import com.phyllipesa.workshopmongo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
