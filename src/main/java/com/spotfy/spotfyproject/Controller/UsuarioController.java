package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.UsuarioDto;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/usuario")
@Slf4j
@RestController

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/criar")
    public ResponseEntity<UsuarioModel> salvarUsuario(@Valid @RequestBody UsuarioDto dto) {
        UsuarioModel usuarioModel = usuarioService.salvarUsuario(dto);
        return ResponseEntity.ok(usuarioModel);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/buscar/musica/{nmMusica}")
    public ResponseEntity<?> buscarPorMusica(@PathVariable String nmMusica) {
        Optional<UsuarioModel> usuario = usuarioService.findByNmMusica(nmMusica);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/artista/{nmArtista}")
    public ResponseEntity<?> buscarPorArtista(@PathVariable String nmArtista) {
        Optional<UsuarioModel> usuario = usuarioService.findByNmArtista(nmArtista);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/genero/{nmGeneroMusical}")
    public ResponseEntity<?> buscarPorGenero(@PathVariable String nmGeneroMusical) {
        Optional<UsuarioModel> usuario = usuarioService.findByGeneroMusical(nmGeneroMusical);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/album/{nmAlbum}")
    public ResponseEntity<?> buscarPorAlbum(@PathVariable String nmAlbum) {
        Optional<UsuarioModel> usuario = usuarioService.findByNmAlbum(nmAlbum);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
