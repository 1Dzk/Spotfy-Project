package com.spotfy.spotfyproject.Controller;

import com.spotfy.spotfyproject.Dto.ArtistaDto;
import com.spotfy.spotfyproject.Model.ArtistaModel;
import com.spotfy.spotfyproject.Service.ArtistaService;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/artistas")
@Slf4j
@RestController
public class ArtistaController {
    private final ArtistaService artistaService;

    @Autowired
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @PostMapping
    public ArtistaModel salvar(@RequestBody ArtistaDto dto) {
        return artistaService.salvar(dto);
    }

    @GetMapping
    public List<ArtistaModel> listarTodos() {
        return artistaService.listarTodos();
    }

    @PutMapping("/{cdArtista}")
    public Optional<ArtistaModel> atualizar(@PathVariable Integer cdArtista, @RequestBody ArtistaDto dto) {
        return artistaService.atualizar(cdArtista, dto);
    }

    @DeleteMapping("/{cdArtista}")
    public void deletar(@PathVariable Integer cdArtista) {
        artistaService.deletar(cdArtista);
    }

    @GetMapping("/buscar/{nmArtista}")
    public List<ArtistaModel> buscarPorNome(@PathVariable String nmArtista) {
        return artistaService.buscarPorNmArtista(nmArtista);
    }

    @GetMapping("/genero/{nmGeneroMusical}")
    public List<ArtistaModel> buscarPorGenero(@PathVariable String nmGeneroMusical) {
        return artistaService.buscarPorGenero(nmGeneroMusical);
    }

    @GetMapping("/populares/{minSeguidores}")
    public List<ArtistaModel> buscarPopulares(@PathVariable Integer minSeguidores) {
        return artistaService.buscarPopulares(minSeguidores);
    }
}

