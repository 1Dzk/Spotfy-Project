package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.FuncionarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Integer> {
    Optional<FuncionarioModel> findByCdEmpresa(Integer cdEmpresa);

    Optional<FuncionarioModel> findByNmUsuario(String nmUsuario);

    Optional<FuncionarioModel> findByAllUsuario(Integer cdUsuario);

    @Transactional
    Optional<FuncionarioModel> deleteByCdFuncionario(Integer cdFuncionario);
    @Transactional
    Optional<FuncionarioModel> deleteByCdUsuario(Integer cdUsuario);


}
