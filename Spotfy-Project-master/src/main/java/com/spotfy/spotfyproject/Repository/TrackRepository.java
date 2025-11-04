package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<TrackModel, Integer> {

    List<TrackModel> findByArtistaCdArtista(Integer cdArtista);

    List<TrackModel> findByNmTrack(String nmTrack);

    List<TrackModel> findByNmGenero(String nmGenero);

    Optional<TrackModel> findByNmTrackAndArtistaCdArtista(String nmTrack, Integer cdArtista);
}
