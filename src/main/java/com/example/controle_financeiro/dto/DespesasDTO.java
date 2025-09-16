package com.example.controle_financeiro.dto;

import com.example.controle_financeiro.model.Despesa;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DespesasDTO {
    private Long id; // apenas o Id da despesa
    private String nome;
    private String description;
    private Double value;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataDespesa;

    private Long userId; // apenas o id do usuário

    public DespesasDTO(Despesa despesa) {
    }

    // getters e setters
}
