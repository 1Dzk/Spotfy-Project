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

@RequestMapping("api/usuario")
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


}
