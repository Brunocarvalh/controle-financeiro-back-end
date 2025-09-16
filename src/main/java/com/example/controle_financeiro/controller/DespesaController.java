package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.model.Despesa;
import com.example.controle_financeiro.repository.DespesaRepository;
import com.example.controle_financeiro.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping("/all")
    public ResponseEntity lista(){
        List<Despesa> despesas =  despesaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(despesas);
    }

    @PostMapping("/register")
    public Despesa save(@RequestBody Despesa despesa) {
        return despesaService.save(despesa);
    }

}
