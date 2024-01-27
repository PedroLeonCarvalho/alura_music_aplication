package com.example.alura_musica_app.repository;

import com.example.alura_musica_app.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, String> {




}