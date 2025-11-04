package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    Optional<FuncionarioModel> findByEmpresaCdEmpresa(Integer cdEmpresa);

    Optional<FuncionarioModel> findByUsuarioNmUsuario(String nmUsuario);

    @Transactional
    void deleteByCdFuncionario(Integer cdFuncionario);


    Optional<FuncionarioModel> findByNmEmailFuncionario(String nmEmailFuncionario);

}
