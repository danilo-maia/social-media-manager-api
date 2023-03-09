package com.danilomaia.workshopspringbootmongodb.repositories;

import com.danilomaia.workshopspringbootmongodb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
