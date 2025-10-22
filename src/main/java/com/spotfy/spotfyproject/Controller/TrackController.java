package com.spotfy.spotfyproject.Controller;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;


    private Integer durationSeconds; // duração em segundos


    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumController album;
}
