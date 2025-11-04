package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.AlbumDto;
import com.spotfy.spotfyproject.Model.AlbumModel;
import com.spotfy.spotfyproject.Service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/albuns")
@Slf4j
@RestController
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public void salvar(@RequestBody AlbumDto dto) {
        albumService.salvar(dto);
    }

    @GetMapping
    public List<AlbumModel> listarTodos() {
        return albumService.listarTodos();
    }

    @GetMapping("/artista/{nmArtista}")
    public Optional<AlbumModel> buscarPorArtista(@PathVariable String nmArtista) {
        return albumService.buscarPorArtista(nmArtista);
    }

    @PutMapping("/{cdAlbum}")
    public Optional<AlbumModel> atualizar(@PathVariable Integer cdAlbum, @RequestBody AlbumDto dto) {
        return albumService.atualizar(cdAlbum, dto);
    }

    @GetMapping("/buscar/{nmAlbum}")
    public List<AlbumModel> buscarPorNomeAlbum(@PathVariable String nmAlbum) {
        return albumService.findByNmAlbum(nmAlbum);
    }

    @GetMapping("/ano/{nuAnoLancamento}")
    public List<AlbumModel> buscarPorAno(@PathVariable Integer nuAnoLancamento) {
        return albumService.findByNuAnoLancamento(nuAnoLancamento);
    }

    @DeleteMapping("/{cdAlbum}")
    public void deletar(@PathVariable Integer cdAlbum) {
        albumService.deletar(cdAlbum);
    }
}
