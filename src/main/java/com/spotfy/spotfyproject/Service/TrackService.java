package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.TrackDto;
import com.spotfy.spotfyproject.Model.TrackModel;
import com.spotfy.spotfyproject.Repository.AlbumRepository;
import com.spotfy.spotfyproject.Repository.TrackRepository;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository, AlbumRepository albumRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackModel salvar(TrackDto dto) {
        TrackModel track = new TrackModel();
        track.setNmTrack(dto.nmTrack());
        track.setCdArtista(dto.cdArtista());
        track.setNmGenero(dto.nmGenero());
        track.setQtReproducao(dto.qtReproducao());
        return trackRepository.save(track);
    }

    public List<TrackModel> listarTodos() {
        return trackRepository.findAll();
    }

    public List<TrackModel> buscarPorArtista(Integer cdArtista) {
        return trackRepository.findByCdArtista(cdArtista);
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

    public Optional<TrackModel> findByNmTrackAndCdArtista(Integer cdArtista, String nmTrack) {
        return trackRepository.findByNmTrackAndCdArtista(nmTrack, cdArtista);
    }

    public void deletar(Integer cdTrack) {
        trackRepository.deleteById(cdTrack);
    }
}
