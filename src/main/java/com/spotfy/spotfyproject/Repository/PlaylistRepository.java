package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.PlaylistModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Integer> {

    List<PlaylistModel> findByCdUsuario(Integer cdUsuario);

    List<PlaylistModel> findByNmPlaylist(String nmPlaylist);


}
