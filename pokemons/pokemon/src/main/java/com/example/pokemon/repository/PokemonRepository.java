package com.example.pokemon.repository;

import com.example.pokemon.entities.Pokemon;
import com.example.pokemon.entities.TipoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByTipoPokemon(TipoPokemon tipoPokemon);

    List<Pokemon> findByTipo(String tipo);

	Optional<Pokemon> findByUuid(String uuid);
	
	
}
