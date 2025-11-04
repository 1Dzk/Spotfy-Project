package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.AlbumDto;
import com.spotfy.spotfyproject.Model.AlbumModel;
import com.spotfy.spotfyproject.Model.ArtistaModel;
import com.spotfy.spotfyproject.Repository.AlbumRepository;
import com.spotfy.spotfyproject.Repository.ArtistaRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    private final ArtistaRepository artistaRepository;

    public AlbumService(AlbumRepository albumRepository, ArtistaRepository artistaRepository) {
        this.albumRepository = albumRepository;
        this.artistaRepository = artistaRepository;
    }


    public AlbumModel salvar(@NotNull AlbumDto dto) {
        AlbumModel album = new AlbumModel();
        album.setNmAlbum(dto.nmAlbum());
        album.setNuAnoLancamento(dto.nuAnoLancamento());
        Integer cdArtista = dto.cdArtista();
        ArtistaModel artista = artistaRepository.findById(cdArtista)
                .orElseThrow(() -> new RuntimeException("Artista com ID " + cdArtista + " não encontrado"));
        album.setArtista(artista);
        return albumRepository.save(album);
    }

    public List<AlbumModel> listarTodos() {
        return albumRepository.findAll();
    }

    public Optional<AlbumModel> buscarPorArtista(String nmArtista) {
        return albumRepository.findBynmArtista(nmArtista);
    }

    public Optional<AlbumModel> atualizar(Integer cdAlbum, AlbumDto dto) {
        return albumRepository.findById(cdAlbum).map(album -> {
            album.setNmAlbum(dto.nmAlbum());
            album.setNuAnoLancamento(dto.nuAnoLancamento());
            return albumRepository.save(album);
        });
    }

    public List<AlbumModel> findByNmAlbum(String nmAlbum) {
        return albumRepository.findByNmAlbum(nmAlbum);
    }

    public List<AlbumModel> findByNuAnoLancamento(Integer nuAnoLancamento) {
        return albumRepository.findByNuAnoLancamento(nuAnoLancamento);
    }

    public void deletar(Integer cdAlbum) {
        albumRepository.deleteByCdAlbum(cdAlbum);
    }
}