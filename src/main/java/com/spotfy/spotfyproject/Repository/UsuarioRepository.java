package com.spotfy.spotfyproject.Repository;


import com.spotfy.spotfyproject.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Integer> {

    Optional<UsuarioModel> findByMusicaName(String nmMusica);
    Optional<UsuarioModel> findByArtista(String nmArtista);
    Optional<UsuarioModel> findByGeneroMusical(String nmGeneroMusical);
    Optional<UsuarioModel> findByAlbum(String nmAlbum);
}
