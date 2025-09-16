package com.example.controle_financeiro.controller;


import com.example.controle_financeiro.dto.UserDto;
import com.example.controle_financeiro.repository.UserRepository;
import com.example.controle_financeiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Listar todas os usuarios.
    @GetMapping("/get")
    public List<UserDto> getUser(){
        return userService.listar();
    }

    //Inserir um novo usuário
    @PostMapping("/insert")
    public ResponseEntity<ApiResponse> insertUser(@RequestBody UserDto userDto){
        userService.save(userDto);
        return ResponseEntity.ok(new ApiResponse(true, "Usuário " + userDto.getNome() + " cadastrado com sucesso!!"));
    }

    //Deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletar(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario removido com sucesso"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
