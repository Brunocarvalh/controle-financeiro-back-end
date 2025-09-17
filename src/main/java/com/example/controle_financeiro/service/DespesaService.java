package com.example.controle_financeiro.service;


import com.example.controle_financeiro.dto.DespesasDTO;
import com.example.controle_financeiro.model.Despesa;
import com.example.controle_financeiro.model.User;
import com.example.controle_financeiro.repository.DespesaRepository;
import com.example.controle_financeiro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DespesaService {
    DespesaRepository despesaRepository;
    UserRepository userRepository;

    public DespesaService(DespesaRepository despesaRepository, UserRepository userRepository) {
        this.despesaRepository = despesaRepository;
        this.userRepository = userRepository;
    }

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public DespesasDTO save(DespesasDTO despesaDto) {
        User user = userRepository.findById(despesaDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        Despesa despesa = new Despesa();
        despesa.setNome(despesaDto.getNome());
        despesa.setDescription(despesaDto.getDescription());
        despesa.setDataDespesa(despesaDto.getDataDespesa());
        despesa.setValue(despesaDto.getValue());
        despesa.setUser(user);
        Despesa saved =  despesaRepository.save(despesa);
        return toDTO(saved);
    }

    public List<DespesasDTO> listarTodas() {
        return despesaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<DespesasDTO> listarPorUser(Long userId) {
        return despesaRepository.findAll()
                .stream()
                .filter(d -> d.getUser() != null && d.getUser().getId().equals(userId))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DespesasDTO> findById(Long id) {
        return despesaRepository.findById(id)
                .map(DespesasDTO::new);
    }

    // Conversão de Entity -> DTO
    private DespesasDTO toDTO(Despesa despesa) {
        DespesasDTO dto = new DespesasDTO();
        dto.setId(despesa.getId());
        dto.setNome(despesa.getNome());
        dto.setDescription(despesa.getDescription());
        dto.setValue(despesa.getValue());
        dto.setDataDespesa(despesa.getDataDespesa());
        dto.setUserId(despesa.getUser().getId());
        return dto;
    }

    public void deleteDespesa(Long id) throws Exception {
        if(!despesaRepository.existsById(id)){
            throw new Exception("Despesa com o Id " + id + " não existente");
        }else {
            despesaRepository.deleteById(id);

        }
    }

    public DespesasDTO updateDespesa(Long id, DespesasDTO despesaDto) throws Exception {
        Despesa despesa = despesaRepository.findById(id)
                .orElseThrow(() -> new Exception("Despesa com ID " + id + " não cadastrada!"));
        despesa.setNome(despesaDto.getNome());
        despesa.setDescription(despesaDto.getDescription());
        despesa.setValue(despesaDto.getValue());
        despesa.setDataDespesa(despesaDto.getDataDespesa());
        Despesa salva =  despesaRepository.save(despesa);
        return  toDTO(salva);
    }

}
