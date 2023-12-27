package com.example.pokemon.services;

import java.util.Optional;

import com.example.pokemon.entities.TipoPokemon;
import com.example.pokemon.repository.TipoPokemonRepository;

public class TipoPokemonService {

    private final TipoPokemonRepository tipoPokemonRepository;

 
    public TipoPokemonService(TipoPokemonRepository tipoPokemonRepository) {
        this.tipoPokemonRepository = tipoPokemonRepository;
    }

    public Optional<TipoPokemon> getTipoPokemonByDescripcion(String descripcion) {
        return tipoPokemonRepository.findByDescripcion(descripcion);
    }

    public TipoPokemon saveTipoPokemon(TipoPokemon tipoPokemon) {
      
        return tipoPokemonRepository.save(tipoPokemon);
    }

	public TipoPokemon getByDescripcion(String tipo) {
		
		return null;
	}

 
}
