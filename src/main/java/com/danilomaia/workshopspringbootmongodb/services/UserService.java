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

    public void insert(User obj){
        repository.insert(obj);
    }

    public void deleteById(String id){
        this.findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        User user = this.findById(obj.getId());
        updateData(user, obj);
        return repository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setEmail(obj.getEmail());
        user.setName(obj.getName());
    }
}
