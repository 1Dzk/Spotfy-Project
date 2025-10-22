package com.spotfy.spotfyproject.Service;

import com.spotfy.spotfyproject.Dto.TrackDto;
import com.spotfy.spotfyproject.Repository.AlbumRepository;
import com.spotfy.spotfyproject.Repository.TrackRepository;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;


    public TrackService(TrackRepository trackRepository, AlbumRepository albumRepository) {
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
    }


    public Track salvar(TrackDto dto) {
        Album album = albumRepository.findById(dto.idAlbum())
                .orElseThrow(() -> new RuntimeException("Álbum não encontrado"));


        Track track = new Track();
        track.setTitle(dto.nmFaixa());
        track.setDurationSeconds(dto.nuDuracaoSegundos());
        track.setAlbum(album);
        return trackRepository.save(track);
    }


    public List<Track> listarTodos() {
        return trackRepository.findAll();
    }


    public Optional<Track> buscarPorId(Long idTrack) {
        return trackRepository.findById(idTrack);
    }


    public Optional<Track> atualizarDados(Long idTrack, TrackDto dto) {
        return trackRepository.findById(idTrack).map(track -> {
            track.setTitle(dto.nmFaixa());
            track.setDurationSeconds(dto.nuDuracaoSegundos());
            return trackRepository.save(track);
        });
    }
}
