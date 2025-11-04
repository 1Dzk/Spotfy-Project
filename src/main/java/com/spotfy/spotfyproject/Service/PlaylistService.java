package com.spotfy.spotfyproject.Service;


import com.spotfy.spotfyproject.Dto.PlaylistDto;
import com.spotfy.spotfyproject.Model.PlaylistModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Repository.PlaylistRepository;
import com.spotfy.spotfyproject.Repository.TrackRepository;
import com.spotfy.spotfyproject.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;


    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public PlaylistModel salvar(PlaylistDto dto) {
        PlaylistModel playlist = new PlaylistModel();
        playlist.setNmPlaylist(dto.nmPlaylist());
        playlist.setCdUsuario(dto.cdUsuario());
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

    public List<PlaylistModel> findByCdUsuario(Integer cdUsuario) {
        return playlistRepository.findByCdUsuario(cdUsuario);
    }

    public void deletar(Integer cdPlaylist) {
        playlistRepository.deleteByCdPlaylist(cdPlaylist);
    }
}
