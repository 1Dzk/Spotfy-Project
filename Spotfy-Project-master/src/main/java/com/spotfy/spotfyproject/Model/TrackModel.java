package com.spotfy.spotfyproject.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBTRACK")
public class TrackModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDTRACK")
    private Integer cdTrack;

    @Column(name = "NMTRACK", length = 100, nullable = false)
    private String nmTrack;

    @Column(name = "NMTRACKGENERO", length = 100, nullable = false)
    private String nmGenero;

    @Column(name = "QTREPRODUCAO")
    private Integer qtReproducao;

    @ManyToOne
    @JoinColumn(name = "CDALBUM")
    private AlbumModel album;


    @ManyToOne
    @JoinColumn(name = "CDARTISTA")
    private ArtistaModel artista;
}
