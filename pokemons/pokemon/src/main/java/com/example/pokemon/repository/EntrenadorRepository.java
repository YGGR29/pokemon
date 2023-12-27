package com.example.pokemon.repository;

import com.example.pokemon.entities.Entrenador;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    Optional<Entrenador> findByEmailAndPassword(String email, String password);
    Optional<Entrenador> findByUuid(String uuid);
    
}

