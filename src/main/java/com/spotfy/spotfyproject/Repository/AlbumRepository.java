package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.AlbumModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<AlbumModel, Integer> {

    List<AlbumModel> findByCdArtista(Integer cdArtista);

    List<AlbumModel> findByAnoLancamento(Integer anoLancamento);

    List<AlbumModel> findByNmAlbum(String nmAlbum);

    @Transactional
    Optional<AlbumModel> deleteByCdAlbum (Integer cdAlbum);

}
