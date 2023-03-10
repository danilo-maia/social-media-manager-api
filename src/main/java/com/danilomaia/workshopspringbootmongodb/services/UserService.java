package com.danilomaia.workshopspringbootmongodb.services;

import com.danilomaia.workshopspringbootmongodb.entities.User;
import com.danilomaia.workshopspringbootmongodb.repositories.UserRepository;
import com.danilomaia.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);

        if (user.isEmpty())
            throw new ObjectNotFoundException("Object not found. Id " + id);

        return user.get();
    }
}
