package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.FuncionarioDto;
import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Repository.FuncionarioRepository;
import com.spotfy.spotfyproject.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioModel salvarFuncionario(FuncionarioDto dto) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNmFuncionario(dto.nmFuncionario());
        funcionario.setNutelefone(dto.nuTelefone());
        funcionario.setNuCpf(dto.nuCpf());
        funcionario.setNmSenhaFun(dto.nmSenhaFun());
        return funcionarioRepository.save(funcionario);
    }

    public List<FuncionarioModel> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> findByCdFuncionario(Integer cdFuncionario) {
        return funcionarioRepository.findByCdEmpresa(cdFuncionario);
    }
    public FuncionarioModel login(String email, String senha) {
        FuncionarioModel funcionario = funcionarioRepository.findByEmailFuncionario(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado!"));
        if (!funcionario.getNmSenhaFun().equals(senha)) {
            throw new RuntimeException("Senha incorreta!");
        }
        return funcionario;
    }

    public void deletarFuncionario(Integer cdFuncionario) {
        funcionarioRepository.deleteById(cdFuncionario);
    }

    public UsuarioModel buscarUsuarioPorId(Integer cdUsuario) {
        return usuarioRepository.findById(cdUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
    public void deletarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
