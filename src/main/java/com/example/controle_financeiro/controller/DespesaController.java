package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.dto.DespesasDTO;
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
    public List<DespesasDTO> lista(){
        return despesaService.listarTodas();
    }

    // Listar despesas de um usuário específico
    @GetMapping("/usuario/{userId}")
    public List<DespesasDTO> listarPorUsuario(@PathVariable Long userId) {
        return despesaService.listarPorUser(userId);
    }

    @PostMapping("/register")
    public DespesasDTO save(@RequestBody DespesasDTO despesa) {
        return despesaService.save(despesa);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        despesaService.deleteDespesa(id);
        return ResponseEntity.noContent().build();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
