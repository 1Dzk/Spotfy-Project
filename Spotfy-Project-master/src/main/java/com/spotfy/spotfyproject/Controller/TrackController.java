package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.TrackDto;
import com.spotfy.spotfyproject.Model.TrackModel;
import com.spotfy.spotfyproject.Service.TrackService;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/tracks")
@Slf4j
@RestController
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<TrackModel> listarTodas() {
        return trackService.listarTodos();
    }
    @PostMapping
    public ResponseEntity<TrackModel> salvarTrack(@RequestBody TrackDto dto) {
        try {
            TrackModel trackModel = trackService.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(trackModel);
        } catch (RuntimeException e) {
            log.error("Erro ao salvar a track: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/artista/{cdArtista}")
    public ResponseEntity<List<TrackModel>> findByArtistaCdArtista(@PathVariable Integer cdArtista) {
        List<TrackModel> tracks = trackService.findByArtistaCdArtista(cdArtista);
        if (tracks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/genero/{nmGenero}")
    public ResponseEntity<List<TrackModel>> buscarPorGenero(@PathVariable String nmGenero) {
        List<TrackModel> tracks = trackService.buscarPorGenero(nmGenero);
        if (tracks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/nome/{nmTrack}")
    public ResponseEntity<List<TrackModel>> buscarPorNmTrack(@PathVariable String nmTrack) {
        List<TrackModel> tracks = trackService.findByNmTrack(nmTrack);
        if (tracks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tracks);
    }
}
