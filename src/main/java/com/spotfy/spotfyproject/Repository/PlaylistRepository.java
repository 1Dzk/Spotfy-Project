package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.PlaylistModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Integer> {
}
