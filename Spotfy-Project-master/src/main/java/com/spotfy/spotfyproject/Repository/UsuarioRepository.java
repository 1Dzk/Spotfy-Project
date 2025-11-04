package com.spotfy.spotfyproject.Repository;


import com.spotfy.spotfyproject.Model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    @Transactional
   void deleteByCdUsuario(Integer cdUsuario);
}
