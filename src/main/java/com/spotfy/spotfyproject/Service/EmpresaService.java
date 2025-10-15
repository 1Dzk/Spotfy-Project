package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.EmpresaDto;
import com.spotfy.spotfyproject.Model.EmpresaModel;
import com.spotfy.spotfyproject.Repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaModel salvar(EmpresaDto dto) {
        EmpresaModel empresa = new EmpresaModel();
        empresa.setNmFantasia(dto.nmFantasia());
        empresa.setDsEndereco(dto.dsEndereco());
        empresa.setNuCnpj(dto.nuCnpj());
        empresa.setNuEndereco(dto.nuEndereco());
        empresa.setNmRazao(dto.nmRazao());
        empresa.setFlAtivo(dto.flAtivo());
        return empresaRepository.save(empresa);
    }
    public List<EmpresaModel> listarTodos() {
        return empresaRepository.findAll();
    }

    public List<EmpresaModel> listarEmpresasAtivas() {
        return empresaRepository.findAllByFlAtivo();
    }
    public Optional<EmpresaModel> findByCdEmpresa(Integer cdEmpresa) {
        return empresaRepository.findByCdEmpresa(cdEmpresa);
    }
    public Optional<EmpresaModel>indByNuCnpj(String nuCnpj) {
        return empresaRepository.findByNuCnpj(nuCnpj);
    }
    public Optional<EmpresaModel> atualizarDados(Integer cdEmpresa, EmpresaDto empresaDto) {
        return empresaRepository.findByCdEmpresa(cdEmpresa).map(empresa -> {
            empresa.setNuCnpj(empresaDto.nuCnpj());
            empresa.setNuEndereco(empresaDto.nuEndereco());
            empresa.setNmFantasia(empresaDto.nmFantasia());
            empresa.setNmRazao(empresaDto.nmRazao());
            empresa.setDsEndereco(empresaDto.dsEndereco());
            empresa.setNuTelefone(empresaDto.nuTelefone());
            empresa.setFlAtivo(empresaDto.flAtivo());
            return empresaRepository.save(empresa);
        });
    }

    public void deletarEmpresa(Integer cdEmpresa) {
        empresaRepository.deleteByCdEmpresa(cdEmpresa);
    }
}
