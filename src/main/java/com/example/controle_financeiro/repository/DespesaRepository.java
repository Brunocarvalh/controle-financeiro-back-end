package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByUserId(Long userId);
}
