package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioDto(
        @NotBlank(message = "Não é possivel salvar o funcionário sem nome")
        String nmFuncionario,
        @NotBlank(message = "Não é possivel salvar a senha vazia")
        String nmSenhaFun,
        String nuTelefone,
        @NotBlank(message = "Não é possível deixar o cpf vazio")
        String nuCpf,
        String nmEmailFuncionario,
        Integer cdEmpresa,
        Integer cdUsuario
) {
}
