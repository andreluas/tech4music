package com.tech4music.tech4music.repository;

import com.tech4music.tech4music.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    
}
