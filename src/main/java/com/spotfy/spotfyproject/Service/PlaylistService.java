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
    private final UsuarioRepository userRepository;
    private final TrackRepository trackRepository;


    public PlaylistService(PlaylistRepository playlistRepository, UsuarioRepository userRepository, TrackRepository trackRepository) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
        this.trackRepository = trackRepository;
    }

    public static PlaylistDto findById(Long id) {
    }


    public PlaylistModel salvar(PlaylistDto dto) {
        UsuarioModel Playlist = userRepository.findById(dto.idOwner())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Playlist playlist = new Playlist();
        playlist.setName(dto.nmPlaylist());
        playlist.setOwner(owner);
        playlist.setPublic(dto.isPublic() != null && dto.isPublic());
        return playlistRepository.save(playlist);
    }


    public List<PlaylistModel> listarTodos() {
        return playlistRepository.findAll();
    }


    public Optional<PlaylistModel> buscarPorId(Long idPlaylist) {
        return playlistRepository.findById(idPlaylist);
    }


    public Optional<PlaylistModel> atualizarDados(Long idPlaylist, PlaylistDto dto) {
        return playlistRepository.findById(idPlaylist).map(playlist -> {
            playlist.setName(dto.nmPlaylist());
            playlist.setPublic(dto.isPublic());
            return playlistRepository.save(playlist);
        });
    }


    public PlaylistModel adicionarTrack(Long idPlaylist, Long idTrack, Long idUser) {
        PlaylistModel playlist = playlistRepository.findById(idPlaylist)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));


        if (!playlist.getOwner().getId().equals(idUser)) {
            throw new RuntimeException("Somente o dono pode alterar esta playlist");
        }


        Track track = trackRepository.findById(idTrack)
                .orElseThrow(() -> new RuntimeException("Faixa não encontrada"));


        playlist.getTracks().add(track);
        return playlistRepository.save(playlist);
    }


    public PlaylistModel removerTrack(Long idPlaylist, Long idTrack, Long idUser) {
        PlaylistModel playlist = playlistRepository.findById(idPlaylist)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));
        if (!playlist.getOwner().getId().equals(idUser)) {
            throw new RuntimeException("Somente o dono pode alterar esta playlist");
        }
        playlist.getTracks().removeIf(t -> t.getId().equals(idTrack));
        return playlistRepository.save(playlist);
    }
}
