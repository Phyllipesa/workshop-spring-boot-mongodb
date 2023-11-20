package com.phyllipesa.workshopmongo.domain.repository;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  List<Post> findByTitleContainingIgnoreCase(String text);
}
