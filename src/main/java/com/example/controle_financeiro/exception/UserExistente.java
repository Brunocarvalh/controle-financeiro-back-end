package com.example.controle_financeiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserExistente extends RuntimeException {
    public UserExistente(String message) {
        super(message);
    }
}
