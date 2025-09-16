package com.example.controle_financeiro.service;


import com.example.controle_financeiro.model.Despesa;
import com.example.controle_financeiro.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DespesaService {
    DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public Despesa save(Despesa despesaDto) {
        return  despesaRepository.save(despesaDto);
    }

}
