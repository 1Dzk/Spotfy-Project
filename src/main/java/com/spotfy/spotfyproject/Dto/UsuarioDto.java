package com.spotfy.spotfyproject.Dto;


import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UsuarioDto(
        @NotBlank(message = "Não é possível salvar o usuário sem nome")
        String nmUsuario,
        @NotBlank(message = "Não é possível salvar o usuário sem cpf")
        String nuCpf,
        String nuTelefone,
        @NotBlank(message = "Não é possível salvar o usuário sem uma data de nascimento")
        Date dtUsuario,
        @NotBlank(message = "Não é possível salvar o usuário sem uma senha")
        String nmSenha
){

}
