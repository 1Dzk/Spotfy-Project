package com.spotfy.spotfyproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBARTISTA")
public class ArtistaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDARTISTA")
    private Integer cdArtista;

    @Column(name = "NMARTISTA", length = 100, nullable = false)
    private String nmArtista;
    @Column(name = "NMGENEROMUSICAL", length = 100, nullable = false)
    private String nmGeneroMusical;
    @Column(name = "QTSEGUIDOR", nullable = false)
    private Integer qtSeguidor;
}
