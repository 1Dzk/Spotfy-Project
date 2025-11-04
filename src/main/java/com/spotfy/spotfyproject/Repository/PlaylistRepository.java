package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.PlaylistModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Integer> {

    List<PlaylistModel> findByCdUsuario(Integer cdUsuario);

    Optional<PlaylistModel> findByNmPlaylist(String nmPlaylist);

    @Transactional
    Optional<PlaylistModel> deleteByCdPlaylist(Integer cdPlaylist);

}
