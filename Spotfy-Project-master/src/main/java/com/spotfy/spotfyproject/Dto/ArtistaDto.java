package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArtistaDto(
        @NotBlank(message = "O nome do artista não pode ser vazio")
        String nmArtista,
        @NotBlank(message = "O genero musical não pode ser vazio")
        String nmGeneroMusical,
        @Min(value = 0, message = "A quantidade de seguidores não pode ser menor que zero")
        Integer qtSeguidor
) {

}

