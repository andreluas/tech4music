package com.tech4music.tech4music.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4music.tech4music.service.MusicaServiceImpl;
import com.tech4music.tech4music.shared.MusicaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    MusicaServiceImpl service;

    @GetMapping
    public ResponseEntity<List<MusicaDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaDto> findById(@PathVariable String id) {
        Optional<MusicaDto> musica = service.findById(id);

        if(musica.isPresent()) {
            return new ResponseEntity<>(musica.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> addMusic(@RequestBody @Valid MusicaDto music) {
        return new ResponseEntity<>(service.addMusic(music), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MusicaDto> deleteMusic(@PathVariable String id) {
        service.deleteMusic(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaDto> updateMusic(@RequestBody @Valid MusicaDto music, @PathVariable String id) {
        Optional<MusicaDto> musica = service.updateMusic(music, id);
        
        if(musica.isPresent()) {
            return new ResponseEntity<>(musica.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}