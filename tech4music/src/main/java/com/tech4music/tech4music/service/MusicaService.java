package com.tech4music.tech4music.service;

import java.util.List;
import java.util.Optional;

import com.tech4music.tech4music.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> findAll();
    Optional<MusicaDto> findById(String id);
    MusicaDto addMusic(MusicaDto music);
    void deleteMusic(String id);
    Optional<MusicaDto> updateMusic(MusicaDto music, String id);
}
