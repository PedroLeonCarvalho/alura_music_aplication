package com.example.alura_musica_app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column
    private Genero genero;

    @OneToMany (mappedBy = "artista" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public Artista() {
    }

    public Artista(String nome, Genero genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero +
                ", musicas=" + musicas +
                '}';
    }
}
