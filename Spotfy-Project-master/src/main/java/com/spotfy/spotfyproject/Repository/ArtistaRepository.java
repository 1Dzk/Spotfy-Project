package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.ArtistaModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ArtistaRepository extends JpaRepository<ArtistaModel, Integer> {

    List<ArtistaModel> findByNmArtista(String nmArtista);

    List<ArtistaModel> findByNmGeneroMusical(String nmGeneroMusical);

    @Transactional
    void deleteByCdArtista(Integer cdArtista);

    @Query("SELECT a FROM ArtistaModel a ORDER BY a.qtSeguidor DESC LIMIT 1")
    Optional<ArtistaModel> findTopArtistaRank();

    @Query("SELECT a FROM ArtistaModel a WHERE a.qtSeguidor>= :minSeguidores ORDER BY a.qtSeguidor DESC")
    List<ArtistaModel> findArtistasPopulares(Integer minSeguidores);

}
