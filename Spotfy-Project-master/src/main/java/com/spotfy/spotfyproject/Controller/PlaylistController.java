package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.PlaylistDto;
import com.spotfy.spotfyproject.Model.PlaylistModel;
import com.spotfy.spotfyproject.Service.PlaylistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/playlists")
@Slf4j

public class PlaylistController {

    private final PlaylistService playlistService;
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public PlaylistModel salvar(@RequestBody PlaylistDto dto) {
        return playlistService.salvar(dto);
    }

    @GetMapping
    public List<PlaylistModel> listarTodas() {
        return playlistService.listarTodas();
    }

    @GetMapping("/buscar/{nmPlaylist}")
    public Optional<PlaylistModel> buscarPorNome(@PathVariable String nmPlaylist) {
        return playlistService.findByNmPlaylist(nmPlaylist);
    }

    @GetMapping("/usuario/{cdUsuario}")
    public List<PlaylistModel> buscarPorUsuario(@PathVariable Integer cdUsuario) {
        return playlistService.findByUsuarioCdUsuario(cdUsuario);
    }

    @DeleteMapping("/{cdPlaylist}")
    public void deletar(@PathVariable Integer cdPlaylist) {
        playlistService.deletar(cdPlaylist);
    }

}

