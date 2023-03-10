package com.danilomaia.workshopspringbootmongodb.config;

import com.danilomaia.workshopspringbootmongodb.entities.Post;
import com.danilomaia.workshopspringbootmongodb.entities.User;
import com.danilomaia.workshopspringbootmongodb.entities.dto.AuthorDTO;
import com.danilomaia.workshopspringbootmongodb.repositories.PostRepository;
import com.danilomaia.workshopspringbootmongodb.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.*;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.insert(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.of(2015, 3, 21).atStartOfDay().toInstant(ZoneOffset.UTC), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2015, 3, 23).atStartOfDay().toInstant(ZoneOffset.UTC), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.insert(Arrays.asList(post1, post2));
    }
}
