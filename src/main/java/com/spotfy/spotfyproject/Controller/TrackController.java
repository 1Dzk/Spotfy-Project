package com.spotfy.spotfyproject.Controller;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@Slf4j
@RestController
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
