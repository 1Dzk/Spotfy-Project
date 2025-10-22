package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrackRepository extends JpaRepository<TrackModel, Integer> {

}
