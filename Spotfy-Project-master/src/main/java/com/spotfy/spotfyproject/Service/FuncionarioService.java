package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.FuncionarioDto;
import com.spotfy.spotfyproject.Model.EmpresaModel;
import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Repository.EmpresaRepository;
import com.spotfy.spotfyproject.Repository.FuncionarioRepository;
import com.spotfy.spotfyproject.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    private final UsuarioRepository usuarioRepository;

    private final EmpresaRepository empresaRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }

    public FuncionarioModel salvarFuncionario(FuncionarioDto dto) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNmFuncionario(dto.nmFuncionario());
        EmpresaModel empresa = empresaRepository.findById(dto.cdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada."));
        UsuarioModel usuario = usuarioRepository.findById(dto.cdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        funcionario.setEmpresa(empresa);
        funcionario.setUsuario(usuario);
        funcionario.setNutelefone(dto.nuTelefone());
        funcionario.setNuCpf(dto.nuCpf());
        funcionario.setNmEmailFuncionario(dto.nmEmailFuncionario());
        funcionario.setNmSenhaFun(dto.nmSenhaFun());
        return funcionarioRepository.save(funcionario);
    }

    public Optional<FuncionarioModel> findByEmpresaCdEmpresa(Integer cdFuncionario) {
        return funcionarioRepository.findByEmpresaCdEmpresa(cdFuncionario);
    }
    public FuncionarioModel login(String email, String senha) {
        FuncionarioModel funcionario = funcionarioRepository.findByNmEmailFuncionario(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado!"));
        if (!funcionario.getNmSenhaFun().equals(senha)) {
            throw new RuntimeException("Senha incorreta!");
        }
        return funcionario;
    }

    public Optional<FuncionarioModel> findByUsuarioNmUsuario(String nmUsuario) {
        return funcionarioRepository.findByUsuarioNmUsuario(nmUsuario);
    }

    public void deleteByCdFuncionario(Integer cdFuncionario) {
        funcionarioRepository.deleteByCdFuncionario(cdFuncionario);
    }

    public UsuarioModel buscarUsuarioPorCd(Integer cdUsuario) {
        return usuarioRepository.findById(cdUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public Optional<FuncionarioModel> findById(Integer cdFuncionario) {
        return funcionarioRepository.findById(cdFuncionario);
    }
}
