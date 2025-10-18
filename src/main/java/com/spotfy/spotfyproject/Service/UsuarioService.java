package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.UsuarioDto;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel salvarUsuario(UsuarioDto dto) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNmUsuario(dto.nmUsuario());
        usuario.setNmSenhaUsuario(dto.nmSenha());
        usuario.setNuCpf(dto.nuCpf());
        usuario.setNuTelefone(dto.nuTelefone());
        usuario.setDtUsuario(dto.dtUsuario());
        return usuarioRepository.save(usuario);
    }


}
