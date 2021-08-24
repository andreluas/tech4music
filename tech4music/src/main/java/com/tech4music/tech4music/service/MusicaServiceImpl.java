package com.tech4music.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4music.tech4music.model.Musica;
import com.tech4music.tech4music.repository.MusicaRepository;
import com.tech4music.tech4music.shared.MusicaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {
 
    @Autowired
    MusicaRepository repository;

    // Busca todas as musicas
    @Override
    public List<MusicaDto> findAll() {
        List<Musica> musicas = repository.findAll();
        return musicas.stream()
        .map(m -> new ModelMapper().map(m, MusicaDto.class))
        .collect(Collectors.toList());
    }

    // Busca uma musica por Id
    @Override
    public Optional<MusicaDto> findById(String id) {
        Optional<Musica> musica = repository.findById(id);

        if(musica.isPresent()) {
            return Optional.of(new ModelMapper().map(musica.get(), MusicaDto.class));
        }

        return Optional.empty();
    }

    // Cadastra uma nova musica 
    @Override
    public MusicaDto addMusic(MusicaDto music) {
        Musica saveMusic = new ModelMapper().map(music, Musica.class);
        saveMusic = repository.save(saveMusic);
        return new ModelMapper().map(saveMusic, MusicaDto.class);
    }

    // Deleta uma musica
    @Override
    public void deleteMusic(String id) {
        repository.deleteById(id);        
    }

    // Atualiza uma musica
    @Override
    public Optional<MusicaDto> updateMusic(MusicaDto music, String id) {
        Optional<Musica> musica = repository.findById(id);
        Musica saveMusic = new ModelMapper().map(music, Musica.class);
        
        if(musica.isPresent()) {
            saveMusic.setId(id);
            saveMusic = repository.save(saveMusic);
            return Optional.of(new ModelMapper().map(saveMusic, MusicaDto.class));
        }

        return Optional.empty();
    }
}
