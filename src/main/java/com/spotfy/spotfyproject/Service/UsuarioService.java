package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.UsuarioDto;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<UsuarioModel> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> findByNmMusica(String  nmMusica) {
        return usuarioRepository.findByNmMusica(nmMusica);
    }
    public Optional<UsuarioModel> findByNmArtista(String  nmArtista) {
        return usuarioRepository.findByNmArtista(nmArtista);
    }

    public Optional<UsuarioModel> findByGeneroMusical(String nmGeneroMusical) {
        return usuarioRepository.findByGeneroMusical(nmGeneroMusical);
    }

    public Optional<UsuarioModel> findByNmAlbum(String nmAlbum) {
        return usuarioRepository.findByNmAlbum(nmAlbum);
    }

    public void deleteByCdUsuario(Integer cdUsuario) {
        usuarioRepository.deleteByCdUsuario(cdUsuario);
    }
}
