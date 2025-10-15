package com.spotfy.spotfyproject.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.ui.Model;

public record EmpresaDto(
        @NotBlank(message = "Não é possível salvar a empresa sem uma razão social")
        String nmRazao,
        String nmFantasia,
        @NotBlank(message = "Não é possível salvar a empresa sem um CNPJ")
        String nuCnpj,
        String nuTelefone,
        @NotBlank(message = "Não é possível salvar a empresa sem endereço")
        String dsEndereco,
        String nuEndereco,
        @Pattern(regexp = "^S|N$", message = "Só é possivel salvar a empresa" +
                "Com 'S' ou 'N' para indicar o status")
        String flAtivo


) {
}