package br.com.aircnc.aircnc.controllers;

import br.com.aircnc.aircnc.dtos.UserDTO;
import br.com.aircnc.aircnc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody  UserDTO dto){
        UserDTO user = service.create(dto);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }


}
