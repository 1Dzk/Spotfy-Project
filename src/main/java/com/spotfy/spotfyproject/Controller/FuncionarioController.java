package com.spotfy.spotfyproject.Controller;


import com.spotfy.spotfyproject.Dto.FuncionarioDto;
import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/funcionario")
@RestController
@Slf4j

public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> salvarFuncionario(@RequestBody FuncionarioDto dto){
        FuncionarioModel funcionarioModel = funcionarioService.salvarFuncionario(dto);
        return ResponseEntity.ok(funcionarioModel);
    }
    
}
