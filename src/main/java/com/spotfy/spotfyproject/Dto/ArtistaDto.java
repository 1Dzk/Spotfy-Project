package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;

public record ArtistaDto(
        @NotBlank(message = "O nome do artista não pode ser vazio")
        String nmArtista,
        @NotBlank(message = "O genero musical não pode ser vazio")
        String nmGeneroMusical,
        Integer qtSeguidores
) {

}

