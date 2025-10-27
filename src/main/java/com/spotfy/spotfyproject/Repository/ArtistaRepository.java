package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.ArtistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<ArtistaModel, Integer> {

    List<ArtistaModel> findByNmArtista(String nmArtista);

    List<ArtistaModel> findByNmGeneroMusical(String nmGeneroMusical);

    @Query("SELECT a FROM ArtistaModel a ORDER BY a.qtSeguidor DESC LIMIT 1")
    Optional<ArtistaModel> findTopArtistaRank();

    @Query("SELECT a FROM ArtistaModel a WHERE a.qtSeguidor>= :minSeguidores ORDER BY a.qtSeguidor DESC")
    List<ArtistaModel> findArtistasPopulares(Integer minSeguidores);
}
