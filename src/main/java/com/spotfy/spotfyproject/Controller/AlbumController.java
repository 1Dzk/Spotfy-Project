package com.spotfy.spotfyproject.Controller;


import jakarta.persistence.*;
import lombok.*;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;


    private Integer year;


    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistaController artist;


    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<TrackController> tracks = new ArrayList<>();
}
