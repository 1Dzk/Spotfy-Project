package com.spotfy.spotfyproject.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlbumDto(
        @NotBlank(message = "O título do álbum não pode ser vazio")
        String nmAlbum,

        @NotNull(message = "O ano do álbum é obrigatório")
        Integer nuAno,

        @NotNull(message = "O ID do artista é obrigatório")
        Long idArtista
) {
}
