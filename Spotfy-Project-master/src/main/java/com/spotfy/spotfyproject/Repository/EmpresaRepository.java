package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.EmpresaModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {
    Optional<EmpresaModel> findByCdEmpresa(Integer cdEmpresa);

    Optional<EmpresaModel> findByNuCnpj(String nuCnpj);

    @Query("SELECT emp FROM EmpresaModel emp WHERE emp.flAtivo = 'S' ")
    List<EmpresaModel> findAllByFlAtivo();

    @Transactional
    void deleteByCdEmpresa(Integer cdEmpresa);

}
