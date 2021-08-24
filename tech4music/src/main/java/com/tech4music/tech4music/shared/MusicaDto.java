package com.tech4music.tech4music.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class MusicaDto {
    private String id;
    @NotBlank(message = "Título não pode estar vazio")
    private String titulo;
    @NotBlank(message = "Artista não pode estar vazio")
    private String artista;
    @NotBlank(message = "Álbum não pode estar vazio")
    private String album;
    @NotEmpty(message = "O genero deve ser preenchido")
    private String genero;
    private int anoLancamento;
    @NotEmpty(message = "O compositor deve ser preenchido")
    private String compositor;

    //#region
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    //#endregion
}
