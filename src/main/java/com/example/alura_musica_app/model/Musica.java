package com.example.alura_musica_app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "musicas")
public class Musica {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String titulo;

@ManyToOne
    private Artista artista;

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", artista=" + artista +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
