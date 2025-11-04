package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.TrackDto;
import com.spotfy.spotfyproject.Model.AlbumModel;
import com.spotfy.spotfyproject.Model.ArtistaModel;
import com.spotfy.spotfyproject.Model.TrackModel;
import com.spotfy.spotfyproject.Repository.AlbumRepository;
import com.spotfy.spotfyproject.Repository.ArtistaRepository;
import com.spotfy.spotfyproject.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    private final ArtistaRepository artistaRepository;

    private final AlbumRepository albumRepository;

    public TrackService(TrackRepository trackRepository, AlbumRepository albumRepository, ArtistaRepository artistaRepository, AlbumRepository albumRepository1) {
        this.trackRepository = trackRepository;
        this.artistaRepository = artistaRepository;
        this.albumRepository = albumRepository1;
    }

    public TrackModel salvar(TrackDto dto) {
        TrackModel track = new TrackModel();
        track.setNmTrack(dto.nmTrack());
        Integer cdArtista= dto.cdArtista();
        ArtistaModel artista = artistaRepository.findById(cdArtista)
                .orElseThrow(() -> new RuntimeException("Artista com ID " + cdArtista + " não encontrado"));
        track.setArtista(artista);
        Integer cdAlbum = dto.cdAlbum();
        AlbumModel album = albumRepository.findById(cdAlbum)
                .orElseThrow(() -> new RuntimeException("Album não encontrado"));
        track.setAlbum(album);
        track.setNmGenero(dto.nmGenero());
        track.setQtReproducao(dto.qtReproducao());
        return trackRepository.save(track);
    }

    public List<TrackModel> listarTodos() {
        return trackRepository.findAll();
    }

    public List<TrackModel> findByArtistaCdArtista(Integer cdArtista) {
        return trackRepository.findByArtistaCdArtista(cdArtista);
    }

    public List<TrackModel> buscarPorGenero(String nmGenero) {
        return trackRepository.findByNmGenero(nmGenero);
    }

    public Optional<TrackModel> atualizar(Integer id, TrackDto dto) {
        return trackRepository.findById(id).map(track -> {
            track.setNmTrack(dto.nmTrack());
            track.setNmGenero(dto.nmGenero());
            track.setQtReproducao(dto.qtReproducao());
            return trackRepository.save(track);
        });
    }

    public List<TrackModel> findByNmTrack(String nmTrack) {
        return trackRepository.findByNmTrack(nmTrack);
    }

    public Optional<TrackModel> findByNmTrackAndArtistaCdArtista(Integer cdArtista, String nmTrack) {
        return trackRepository.findByNmTrackAndArtistaCdArtista(nmTrack, cdArtista);
    }

    public void deletar(Integer cdTrack) {
        trackRepository.deleteById(cdTrack);
    }
}
