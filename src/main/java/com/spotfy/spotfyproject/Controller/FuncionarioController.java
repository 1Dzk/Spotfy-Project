package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.FuncionarioDto;
import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import com.spotfy.spotfyproject.Service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/admin/funcionario")
@RestController
@Slf4j

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<FuncionarioModel> login(@RequestParam String email, @RequestParam String senha) {
        return ResponseEntity.ok(funcionarioService.login(email, senha));
    }

    @GetMapping("/{cdFuncionario}")
    public Optional<FuncionarioModel> buscarPorCd(@PathVariable Integer cdFuncionario) {
        return funcionarioService.findByCdFuncionario(cdFuncionario);
    }


    @PostMapping
    public ResponseEntity<FuncionarioModel> salvarFuncionario(@RequestBody FuncionarioDto dto) {
        FuncionarioModel funcionarioModel = funcionarioService.salvarFuncionario(dto);
        return ResponseEntity.ok(funcionarioModel);
    }

    @GetMapping("/usuarios/{cdUsuario}")
    public UsuarioModel buscarUsuarioPorCd(@PathVariable Integer cdUsuario) {
        return funcionarioService.buscarUsuarioPorCd(cdUsuario);
    }

    @DeleteMapping("/usuarios/{cdUsuario}")
    public void deletarUsuario(@PathVariable Integer cdUsuario) {
        funcionarioService.deletarUsuario(cdUsuario);
    }

}
