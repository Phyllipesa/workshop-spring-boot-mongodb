package com.phyllipesa.workshopmongo.config;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.entities.User;
import com.phyllipesa.workshopmongo.domain.repository.PostRepository;
import com.phyllipesa.workshopmongo.domain.repository.UserRepository;
import com.phyllipesa.workshopmongo.dto.AuthorDto;
import com.phyllipesa.workshopmongo.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * Configuração para inicialização de dados na aplicação.
 */
@Configuration
public class Instalation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  /**
   * Método que será executado ao iniciar a aplicação.
   *
   * @param args Argumentos da linha de comando (não utilizados neste contexto).
   * @throws Exception Exceção que pode ser lançada durante a execução do método.
   */
  @Override
  public void run(String... args) throws Exception {
    // Definindo o formato de data com o fuso horário GMT
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    // Removendo todos os usuários e posts existentes no banco de dados
    userRepository.deleteAll();
    postRepository.deleteAll();

    // Criando e salvando usuários
    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");
    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    // Criando e salvando posts com comentários
    Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", AuthorDto.authorEntityToDto(maria));
    Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", AuthorDto.authorEntityToDto(maria));

    CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), AuthorDto.authorEntityToDto(alex));
    CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), AuthorDto.authorEntityToDto(bob));
    CommentDto c3 = new CommentDto("Tenha um ótimo dia", sdf.parse("23/03/2018"), AuthorDto.authorEntityToDto(alex));

    post1.getComments().addAll(Arrays.asList(c1, c2));
    post2.getComments().addAll(Arrays.asList(c3));
    postRepository.saveAll(Arrays.asList(post1, post2));

    // Associando os posts à usuária Maria
    maria.getPosts().addAll(Arrays.asList(post1, post2));
    userRepository.save(maria);
  }
}
