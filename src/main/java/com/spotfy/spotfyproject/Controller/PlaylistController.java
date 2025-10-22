package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.PlaylistDto;
import com.spotfy.spotfyproject.Service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/playlists")
@RequiredArgsConstructor
public class PlaylistController {
    @PostMapping
    public ResponseEntity<PlaylistDto> create(@RequestBody PlaylistDto dto) {
        return ResponseEntity.ok(PlaylistService.create(dto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(PlaylistService.findById(id));
    }


    @PostMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<PlaylistDto> addTrack(@PathVariable Long playlistId, @PathVariable Long trackId, @RequestParam Long userId) {
    }
}

