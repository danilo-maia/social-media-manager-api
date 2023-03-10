package com.danilomaia.workshopspringbootmongodb.services;

import com.danilomaia.workshopspringbootmongodb.entities.Post;
import com.danilomaia.workshopspringbootmongodb.repositories.PostRepository;
import com.danilomaia.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post findById(String id){
        Optional<Post> Post = repository.findById(id);

        if (Post.isEmpty())
            throw new ObjectNotFoundException("Object not found. Id " + id);

        return Post.get();
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
