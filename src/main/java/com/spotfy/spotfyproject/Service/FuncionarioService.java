package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.FuncionarioDto;
import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

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

    public void deletarFuncionario(Integer cdFuncionario) {
        funcionarioRepository.deleteById(cdFuncionario);
    }
}
