package com.example.controle_financeiro.service;

import com.example.controle_financeiro.dto.DespesasDTO;
import com.example.controle_financeiro.dto.UserDto;
import com.example.controle_financeiro.exception.UserExistente;
import com.example.controle_financeiro.model.User;
import com.example.controle_financeiro.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDto save(UserDto userDto) {
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
        return dto;
    }
    public UserDto updateUser(Long id, UserDto userDto) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuário com ID  " + id + " não encontrado"));
        user.setNome(userDto.getNome());
        user.setEmail(userDto.getEmail());
        user.setSenha(userDto.getSenha());
        User salvo = userRepository.save(user);
        return toDTO(salvo);
    }
    public void deleteUser(Long id) throws Exception {
        if(!userRepository.existsById(id)){
            throw new Exception("Usuario com Id " + id + " não encontrado");
        }else{
            userRepository.deleteById(id);
        }
    }
    public void insertSalary(User user) throws Exception {
        User usuario = userRepository.findById(user.getId())
                .orElseThrow( ()-> new Exception("Usuário com ID " + " não encontrado"));
        usuario.setSalario(user.getSalario());
    }
}
