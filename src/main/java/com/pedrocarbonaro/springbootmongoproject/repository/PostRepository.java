package com.pedrocarbonaro.springbootmongoproject.repository;

import com.pedrocarbonaro.springbootmongoproject.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String args);

    List<Post> findByTitleContainingIgnoreCase(String args);
}
