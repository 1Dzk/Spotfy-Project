package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.PlaylistDto;
import com.spotfy.spotfyproject.Model.PlaylistModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Repository.PlaylistRepository;
import com.spotfy.spotfyproject.Repository.TrackRepository;
import com.spotfy.spotfyproject.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    private final UsuarioRepository usuarioRepository;

    public PlaylistService(PlaylistRepository playlistRepository, UsuarioRepository usuarioRepository) {
        this.playlistRepository = playlistRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PlaylistModel salvar(PlaylistDto dto) {
        PlaylistModel playlist = new PlaylistModel();
        playlist.setNmPlaylist(dto.nmPlaylist());
        Integer CdUsuario = dto.cdUsuario();
        UsuarioModel usuario = usuarioRepository.findById(CdUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + CdUsuario + " não encontrado"));
        playlist.setUsuario(usuario);
        playlist.setFlPublica(dto.flPublica());
        playlist.setQtSeguidor(dto.qtSeguidor());
        return playlistRepository.save(playlist);
    }

    public List<PlaylistModel> listarTodas() {
        return playlistRepository.findAll();
    }

    public Optional<PlaylistModel> findByNmPlaylist(String nmPlaylist) {
        return playlistRepository.findByNmPlaylist(nmPlaylist);
    }

    public List<PlaylistModel> findByUsuarioCdUsuario(Integer cdUsuario) {
        return playlistRepository.findByUsuarioCdUsuario(cdUsuario);
    }

    public void deletar(Integer cdPlaylist) {
        playlistRepository.deleteByCdPlaylist(cdPlaylist);
    }
}
