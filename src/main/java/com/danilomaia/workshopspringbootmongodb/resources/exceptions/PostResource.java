package com.danilomaia.workshopspringbootmongodb.resources.exceptions;

import com.danilomaia.workshopspringbootmongodb.entities.Post;
import com.danilomaia.workshopspringbootmongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private final PostService service;

    public PostResource(PostService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
