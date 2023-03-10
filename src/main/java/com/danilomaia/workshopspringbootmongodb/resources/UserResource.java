package com.danilomaia.workshopspringbootmongodb.resources;

import com.danilomaia.workshopspringbootmongodb.entities.dto.UserDTO;
import com.danilomaia.workshopspringbootmongodb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = service.findAll().stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }
}
