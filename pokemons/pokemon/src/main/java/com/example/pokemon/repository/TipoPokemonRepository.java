package com.example.pokemon.repository;

import com.example.pokemon.entities.TipoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Long> {
    Optional<TipoPokemon> findByDescripcion(String descripcion);
    
}
