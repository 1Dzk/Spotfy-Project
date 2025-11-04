package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.PlaylistModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistModel, Integer> {

    List<PlaylistModel> findByUsuarioCdUsuario(Integer cdUsuario);

    Optional<PlaylistModel> findByNmPlaylist(String nmPlaylist);

    @Transactional
    void deleteByCdPlaylist(Integer cdPlaylist);

}
