package com.pedrocarbonaro.springbootmongoproject.controllers;

import com.pedrocarbonaro.springbootmongoproject.controllers.util.URL;
import com.pedrocarbonaro.springbootmongoproject.domain.Post;
import com.pedrocarbonaro.springbootmongoproject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);

        return ResponseEntity.ok().body(posts);
    }
}
