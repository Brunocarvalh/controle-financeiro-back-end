package com.example.controle_financeiro.service;

import com.example.controle_financeiro.model.User;
import com.example.controle_financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

}
