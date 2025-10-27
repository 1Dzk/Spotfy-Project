package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.AlbumDto;
import com.spotfy.spotfyproject.Model.AlbumModel;
import com.spotfy.spotfyproject.Repository.AlbumRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public AlbumModel salvar(@NotNull AlbumDto dto) {
        AlbumModel album = new AlbumModel();
        album.setNmAlbum(dto.nmAlbum());
        album.setNuAnoLancamento(dto.nuAnoLancamento());
        album.setCdArtista(dto.cdArtista());
        return albumRepository.save(album);
    }

    public List<AlbumModel> listarTodos() {
        return albumRepository.findAll();
    }

    public List<AlbumModel> buscarPorArtista(Integer cdArtista) {
        return albumRepository.findByCdArtista(cdArtista);
    }

    public Optional<AlbumModel> atualizar(Integer cdAlbum, AlbumDto dto) {
        return albumRepository.findById(cdAlbum).map(album -> {
            album.setNmAlbum(dto.nmAlbum());
            album.setNuAnoLancamento(dto.nuAnoLancamento());
            return albumRepository.save(album);
        });
    }

    public void deletar(Integer cdAlbum) {
        albumRepository.deleteById(cdAlbum);
    }
}