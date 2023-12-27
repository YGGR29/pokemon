package com.example.pokemon.controller;

import java.util.List;
import java.util.Optional;

import com.example.pokemon.entities.Pokemon;
import com.example.pokemon.repository.PokemonRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/api/entrenador")
@CrossOrigin
public class PokemonController {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Optional<Pokemon> existingPokemonOptional = pokemonRepository.findById(id);
        if (existingPokemonOptional.isPresent()) {
            Pokemon existingPokemon = existingPokemonOptional.get();
           
            existingPokemon.setNombre(pokemon.getNombre());
            
            return pokemonRepository.save(existingPokemon);
        } else {
            return null; 
        }
    }

    public boolean deletePokemon(Long id) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isPresent()) {
            pokemonRepository.deleteById(id);
            return true;
        } else {
            return false; 
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginEntrenador(@RequestParam String email, @RequestParam String contraseña) {
        PokemonController entrenadorService;
		Optional<String> uuidOptional = Optional.empty();
        return uuidOptional.map(uuid -> new ResponseEntity<>(uuid, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

    
    public ResponseEntity<List<Pokemon>> getPokemonsByTipo(@PathVariable String tipo) {
        PokemonController pokemonService = null;
		List<Pokemon> pokemones = (List<Pokemon>) pokemonService.getPokemonsByTipo(tipo);
        return new ResponseEntity<>(pokemones, HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<Pokemon> addPokemon1(@RequestBody Pokemon pokemon) {
        PokemonController pokemonService = null;
		Pokemon createdPokemon = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }
}


