package com.example.controle_financeiro.controller;


import com.example.controle_financeiro.model.User;
import com.example.controle_financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/insert")
    public ResponseEntity insertUser(@RequestBody User user){
        return  ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

}
