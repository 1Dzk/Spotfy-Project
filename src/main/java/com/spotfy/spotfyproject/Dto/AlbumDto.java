package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlbumDto(
        @NotBlank(message = "O nome do álbum não pode ser vazio")
        String nmAlbum,

        @NotNull(message = "O ano de lançamento é obrigatório")
        Integer nuAnoLancamento,

        @NotNull(message = "O ID do artista é obrigatório")
        Integer cdArtista
) {
}