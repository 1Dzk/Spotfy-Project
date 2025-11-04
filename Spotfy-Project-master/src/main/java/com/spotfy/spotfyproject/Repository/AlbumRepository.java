package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.AlbumModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AlbumRepository extends JpaRepository<AlbumModel, Integer> {

    Optional<AlbumModel> findBynmArtista(String nmArtista);

    List<AlbumModel> findByNuAnoLancamento(Integer nuAnoLancamento);

    List<AlbumModel> findByNmAlbum(String nmAlbum);

    @Transactional
    void deleteByCdAlbum (Integer cdAlbum);

}
