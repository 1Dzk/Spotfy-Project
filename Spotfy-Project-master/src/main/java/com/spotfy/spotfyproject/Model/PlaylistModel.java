package com.spotfy.spotfyproject.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBPLAYLIST")
public class PlaylistModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDPLAYLIST")
    private Integer cdPlaylist;

    @Column(name = "NMARTISTA", length = 100, nullable = false)
    private String nmArtista;

    @Column(name = "NMPLAYLIST", length = 100 , nullable = false)
    private String nmPlaylist;

    @Column(name = "FLPUBLICA")
    private Boolean flPublica;

    @Column(name = "QTSEGUIDOR")
    private Integer qtSeguidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CDUSUARIO", nullable = false)
    private UsuarioModel usuario;


    @ManyToMany
    @JoinTable(
            name = "TBPLAYLISTTRACK",
            joinColumns = @JoinColumn(name = "CDPLAYLIST"),
            inverseJoinColumns = @JoinColumn(name = "CDTRACK")
    )
    private List<TrackModel> tracks;
}
