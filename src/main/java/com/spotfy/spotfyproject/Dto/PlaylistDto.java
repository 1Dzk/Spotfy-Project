package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlaylistDto(
        @NotBlank(message = "O nome da playlist não pode ser vazio")
        String nmPlaylist,

        @NotNull(message = "O ID do usuário é obrigatório")
        Integer cdUsuario,

        @NotBlank(message = "O nome do artista não pode ser vazio")
        String nmArtista,
        Boolean flPublica,
        Integer qtSeguidor

) {

}
