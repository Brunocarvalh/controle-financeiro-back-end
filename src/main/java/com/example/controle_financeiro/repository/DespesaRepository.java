package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByUserId(Long userId);
    //Despesa findDespesaById(Long id);

    //List<Despesa> findByDataDespesaBetween(LocalDate dataDespesaStart, LocalDate dataDespesaEnd);

    List<Despesa> findByDataDespesaBetweenAndUser_Id(LocalDate dataDespesaAfter, LocalDate dataDespesaBefore, Long userId);
}
