package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.dto.DespesasDTO;
import com.example.controle_financeiro.repository.DespesaRepository;
import com.example.controle_financeiro.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private DespesaRepository despesaRepository;

    //Endpoint para retornar todas as despesas.
    @GetMapping("/all")
    public List<DespesasDTO> lista(){
        return despesaService.listarTodas();
    }

    // Listar despesas de um usuário específico
    @GetMapping("/usuario/{userId}")
    public List<DespesasDTO> listarPorUsuario(@PathVariable Long userId) {
        return despesaService.listarPorUser(userId);
    }

    //Listar despesa especifica
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<DespesasDTO> dto = despesaService.findById(id);
        if(dto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa com o id " + id + " não encontrada.");
        }
        return  ResponseEntity.ok(dto);
    }

    //Registrar nova despesa.
    @PostMapping("/register")
    public DespesasDTO save(@RequestBody DespesasDTO despesa) {
        return despesaService.save(despesa);
    }

    //Deletar despesa
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) throws Exception {
        despesaService.deleteDespesa(id);
        return ResponseEntity.ok(new ApiResponse(true, "Despesa removida com sucesso"));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
