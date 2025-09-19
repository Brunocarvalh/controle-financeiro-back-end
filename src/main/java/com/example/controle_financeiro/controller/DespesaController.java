package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.dto.DespesasDTO;


import com.example.controle_financeiro.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    //Endpoint para retornar todas as despesas.
    @GetMapping()
    public List<DespesasDTO> listarTodas(){
        return despesaService.listarTodas();
    }
    // Listar despesas de um usuario específico
    @GetMapping("/usuario/{userId}")
    public List<DespesasDTO> listarDespesaPorUsuario(@PathVariable Long userId) {
        return despesaService.listarPorUser(userId);
    }
    /*Listar despesa especifica
        @GetMapping("/{id}")
    public ResponseEntity<?> findDespesaById(@PathVariable Long id){
        Optional<DespesasDTO> dto = despesaService.findById(id);
        if(dto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa com o id " + id + " não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }*/
    //Registrar nova despesa.
    @PostMapping()
    public DespesasDTO saveDespesa(@RequestBody DespesasDTO despesa) {
        return despesaService.saveDespesa(despesa);
    }

    //Deletar despesa
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteDespesa(@PathVariable Long id) throws Exception {
        despesaService.deleteDespesa(id);
        return ResponseEntity.ok(new ApiResponse(true, "Despesa removida com sucesso"));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    //Atualizar despesa.
    @PutMapping("/update/{id}")
    public ResponseEntity<DespesasDTO>  updateDepesa(@PathVariable Long id, @RequestBody DespesasDTO despesaDTO) {
        try{
            DespesasDTO atualizado = despesaService.updateDespesa(id, despesaDTO);
            return ResponseEntity.ok(atualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/saldo/{id}")
    public ResponseEntity<ApiResponse> getSaldo(@PathVariable Long id){
        despesaService.getSaldo(id);
        return ResponseEntity.ok(new ApiResponse(true, "Saldo", despesaService.getSaldo(id)));
    }

    @GetMapping("/filter/{id}")
    public ResponseEntity<List<DespesasDTO>> filterByDataDespesa(@PathVariable Long id, @RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim) {
        try{
            List<DespesasDTO> despesaFiltrada = despesaService.filterByDataCompra(id, dataInicio, dataFim);
            return ResponseEntity.status(HttpStatus.OK).body(despesaFiltrada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
