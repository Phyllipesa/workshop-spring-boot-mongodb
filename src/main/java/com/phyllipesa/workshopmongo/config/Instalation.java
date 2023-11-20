package com.phyllipesa.workshopmongo.config;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.entities.User;
import com.phyllipesa.workshopmongo.domain.repository.PostRepository;
import com.phyllipesa.workshopmongo.domain.repository.UserRepository;
import com.phyllipesa.workshopmongo.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instalation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");
    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", AuthorDto.authorEntityToDto(maria));
    Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", AuthorDto.authorEntityToDto(maria));
    postRepository.saveAll(Arrays.asList(post1, post2));
  }
}
