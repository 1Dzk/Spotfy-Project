package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.ArtistaDto;
import com.spotfy.spotfyproject.Model.ArtistaModel;
import com.spotfy.spotfyproject.Repository.ArtistaRepository;
import com.spotfy.spotfyproject.Repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;


    public ArtistaService(ArtistaRepository artistaRepository, EmpresaRepository empresaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public ArtistaModel salvar(ArtistaDto dto) {
        ArtistaModel artista = new ArtistaModel();
        artista.setNmArtista(dto.nmArtista());
        artista.setNmGeneroMusical(dto.nmGeneroMusical());
        artista.setQtSeguidor(dto.qtSeguidores());
        return artistaRepository.save(artista);
    }

    public List<ArtistaModel> listarTodos() {
        return artistaRepository.findAll();
    }

    public Optional<ArtistaModel> atualizar(Integer cdArtista, ArtistaDto dto) {
        return artistaRepository.findById(cdArtista).map(artista -> {
            artista.setNmArtista(dto.nmArtista());
            artista.setNmGeneroMusical(dto.nmGeneroMusical());
            artista.setQtSeguidor(dto.qtSeguidores());
            return artistaRepository.save(artista);
        });
    }

    public List<ArtistaModel> buscarPorNmArtista(String nmArtista) {
        return artistaRepository.buscarPorNmArtista(nmArtista);
    }

    public void deletar(Integer cdArtista) {
        artistaRepository.deleteByCdArtista(cdArtista);
    }

    public List<ArtistaModel> buscarPorGenero(String nmGeneroMusical) {
        return artistaRepository.findByNmGeneroMusical(nmGeneroMusical);
    }

    public List<ArtistaModel> buscarPopulares(Integer minSeguidores) {
        return artistaRepository.findArtistasPopulares(minSeguidores);
    }
}
