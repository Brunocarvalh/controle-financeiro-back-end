package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
