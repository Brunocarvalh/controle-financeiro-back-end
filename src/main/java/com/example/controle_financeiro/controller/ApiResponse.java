package com.example.controle_financeiro.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Double salario;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public ApiResponse(boolean success, String message, double salario) {
        this.success = success;
        this.message = message;
        this.salario = salario;
    }
}
