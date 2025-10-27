package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.FuncionarioModel;
import com.spotfy.spotfyproject.Model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Integer> {
    Optional<FuncionarioModel> findByCdEmpresa(Integer cdEmpresa);

    Optional<UsuarioModel> findByNmUsuario(String nmUsuario);

    Optional<UsuarioModel> findByAllUsuario(Integer cdUsuario);

    @Transactional
    Optional<FuncionarioModel> deleteByCdFuncionario(Integer cdFuncionario);
    @Transactional
    Optional<FuncionarioModel> deleteByCdUsuario(Integer cdUsuario);


    Optional<FuncionarioModel> findByEmailFuncionario(String email);

}
