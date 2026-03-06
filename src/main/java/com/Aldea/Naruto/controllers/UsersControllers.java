package com.Aldea.Naruto.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aldea.Naruto.dto.MessageResponseDTO;
import com.Aldea.Naruto.dto.UsersRequestDTO;
import com.Aldea.Naruto.dto.UsersResponseDTO;
import com.Aldea.Naruto.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersControllers {

    private final UsersService usersService;
    // Inyeccion de dependencias

    public UsersControllers(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping()
    public ResponseEntity<UsersResponseDTO> createUser(@RequestBody UsersRequestDTO usersRequestDto) {

        UsersResponseDTO response = usersService.createUser(usersRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping()
    public ResponseEntity<List<UsersResponseDTO>> getUsers() {
        List<UsersResponseDTO> response = usersService.getUsers();
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> getUser(@PathVariable Long id) {
        UsersResponseDTO response = usersService.getUser(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> deleteUser(@PathVariable Long id) {
        MessageResponseDTO response = usersService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
