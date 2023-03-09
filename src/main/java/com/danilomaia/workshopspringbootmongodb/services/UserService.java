package com.danilomaia.workshopspringbootmongodb.services;

import com.danilomaia.workshopspringbootmongodb.entities.User;
import com.danilomaia.workshopspringbootmongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
