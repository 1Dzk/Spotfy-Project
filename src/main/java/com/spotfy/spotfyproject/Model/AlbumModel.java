package com.spotfy.spotfyproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBALBUM")
public class AlbumModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDALBUM")
    private Integer cdAlbum;

    @Column(name = "NMALBUM", length = 100, nullable = false)
    private String nmAlbum;

    @Column(name = "NUANOLANCAMENTO", nullable = false)
    private Integer nuAnoLancamento;

    @Column(name = "QTREPRODUCAO")
    private Integer qtReproducao;

    @Column(name = "CDARTISTA",nullable = false)
    private Integer cdArtista;

    @ManyToOne
    @JoinColumn(name = "CDARTISTA")
    private ArtistaModel artista;

}

