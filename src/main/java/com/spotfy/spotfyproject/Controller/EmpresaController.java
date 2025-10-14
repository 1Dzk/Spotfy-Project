package com.spotfy.spotfyproject.Controller;


import com.gerenciamento.estoque.Dto.EmpresaDto;
import com.gerenciamento.estoque.Model.EmpresaModel;
import com.gerenciamento.estoque.Services.EmpresaServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/empresa")
@RestController
@Slf4j

public class EmpresaController {

    private final EmpresaServices empresaService;
    public EmpresaController(EmpresaServices empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<EmpresaModel> criar(@Valid @RequestBody EmpresaDto dto ){
        EmpresaModel empresaModel = empresaService.salvar(dto);
        return ResponseEntity.ok(empresaModel);
    }
    @GetMapping
    public ResponseEntity<List<EmpresaModel>> listarTodas(){
        return ResponseEntity.ok(empresaService.listarTodas());
    }
    @GetMapping("/ativas")
    public ResponseEntity<List<EmpresaModel>> listarAtivas(){
        return ResponseEntity.ok(empresaService.listarEmpresasAtivas());
    }

    @GetMapping("/{cdEmpresa}")
    public ResponseEntity<EmpresaModel> listarPorCdEmpresa
            (@PathVariable Integer cdEmpresa){
        return empresaService.findByCdEmpresa(cdEmpresa).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());



    }


}
