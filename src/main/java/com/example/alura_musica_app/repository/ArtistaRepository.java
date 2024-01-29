package com.example.alura_musica_app.repository;

import com.example.alura_musica_app.model.Artista;
import com.example.alura_musica_app.model.Genero;
import com.example.alura_musica_app.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {


    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome% ")
List<Musica> buscaMusicaPorArtista(String nome);
}