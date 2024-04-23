package com.pedrocarbonaro.springbootmongoproject.services;

import com.pedrocarbonaro.springbootmongoproject.domain.Post;
import com.pedrocarbonaro.springbootmongoproject.repository.PostRepository;
import com.pedrocarbonaro.springbootmongoproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object id wasn't found!"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }
}
