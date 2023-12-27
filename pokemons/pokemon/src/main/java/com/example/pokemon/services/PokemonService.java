package com.example.pokemon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pokemon.entities.Pokemon;
import com.example.pokemon.entities.TipoPokemon;
import com.example.pokemon.repository.PokemonRepository;

public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    public Pokemon addPokemon1(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public List<Pokemon> getPokemonsByTipo(String tipo) {
        return pokemonRepository.findByTipo(tipo);
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> getPokemonesByTipo(TipoPokemon tipoPokemon) {
        return pokemonRepository.findByTipoPokemon(tipoPokemon);
    }

    public Pokemon savePokemon(Pokemon pokemon) {
     
        return pokemonRepository.save(pokemon);
    }

	public Pokemon registrarPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pokemon getByUuid(String pokemonUuid) {
		// TODO Auto-generated method stub
		return null;
	}

    
}

