package com.phyllipesa.workshopmongo.domain.resources;

import com.phyllipesa.workshopmongo.domain.entities.Post;
import com.phyllipesa.workshopmongo.domain.resources.util.URL;
import com.phyllipesa.workshopmongo.domain.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {
  @Autowired
  private PostService postService;

  @GetMapping("/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post post = postService.findById(id);
    return ResponseEntity.ok().body(post);
  }

  @GetMapping("/titlesearch")
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
    text = URL.decodeParam(text);
    List<Post> postList = postService.findByTitle(text);
    return ResponseEntity.ok().body(postList);
  }
}
