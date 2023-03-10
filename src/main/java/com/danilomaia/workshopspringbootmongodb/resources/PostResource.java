package com.danilomaia.workshopspringbootmongodb.resources;

import com.danilomaia.workshopspringbootmongodb.entities.Post;
import com.danilomaia.workshopspringbootmongodb.resources.util.URL;
import com.danilomaia.workshopspringbootmongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(service.findByTitle(text));
    }
}
