package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TrackDto(
        @NotBlank(message = "O nome da música não pode ser vazio")
        String nmTrack,
        @NotNull(message = "O ID do álbum é obrigatório")
        Integer cdAlbum,

        @NotNull(message = "A duração da música é obrigatória (em segundos)")
        Integer nuDuracao,

        @NotBlank(message = "O genero não pode ser vazio")
        String nmGenero,
        Integer qtReproducao,
        Integer cdArtista
) {
}

