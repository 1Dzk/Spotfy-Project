package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TrackRepository extends JpaRepository<TrackModel, Integer> {

    List<TrackModel> findByCdArtista(Integer cdArtista);

    List<TrackModel> findByNmTrack(String nmTrack);

    List<TrackModel> findByNmGenero(String nmGenero);

    Optional<TrackModel> findByNmTrackAndCdArtista(String nmTrack, Integer cdArtista);
}
