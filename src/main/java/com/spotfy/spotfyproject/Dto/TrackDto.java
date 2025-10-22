package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TrackDto(
        @NotBlank(message = "O nome da faixa não pode ser vazio")
        String nmFaixa,

        @NotNull(message = "A duração da faixa é obrigatória")
        Integer nuDuracaoSegundos,

        @NotNull(message = "O ID do álbum é obrigatório")
        Long idAlbum
) {
}
