package com.example.controle_financeiro.service;

import com.example.controle_financeiro.dto.DespesasDTO;
import com.example.controle_financeiro.dto.UserDto;
import com.example.controle_financeiro.exception.UserExistente;
import com.example.controle_financeiro.model.User;
import com.example.controle_financeiro.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(@RequestBody UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new UserExistente("Usuário já cadastrado");
        }else{
            User user = new User();
            user.setNome(userDto.getNome());
            user.setEmail(userDto.getEmail());
            user.setSenha(userDto.getSenha());
            User salvo = userRepository.save(user);

            return toDTO(salvo);
        }
    }

    public List<UserDto> listar() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private UserDto toDTO(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        dto.setSenha(user.getSenha());

        // se quiser retornar despesas do usuário
        if (user.getDespesas() != null) {
            List<DespesasDTO> despesasDTO = user.getDespesas().stream().map(d -> {
                DespesasDTO dd = new DespesasDTO();
                dd.setId(d.getId());
                dd.setNome(d.getNome());
                dd.setDescription(d.getDescription());
                dd.setValue(d.getValue());
                dd.setDataDespesa(d.getDataDespesa());
                dd.setUserId(user.getId());
                return dd;
            }).collect(Collectors.toList());

            dto.setDespesas(despesasDTO);
        }

        return dto;
    }

    public void deleteUser(Long id) throws Exception {
        if(!userRepository.existsById(id)){
            throw new Exception("Usuario com Id " + id + " não encontrado");
        }else{
            userRepository.deleteById(id);
        }
    }

}
