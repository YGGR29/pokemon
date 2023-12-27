package com.example.pokemon.services;

import java.util.List;
import java.util.Optional;

import com.example.pokemon.entities.Entrenador;
import com.example.pokemon.entities.Pokemon;
import com.example.pokemon.repository.EntrenadorRepository;
import com.example.pokemon.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService { 

    private static EntrenadorRepository entrenadorRepository = null;
	private PokemonRepository pokemonRepository;

    
    @Autowired
    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        EntrenadorService.entrenadorRepository = entrenadorRepository;
    }
    
    public EntrenadorService(EntrenadorRepository entrenadorRepository, PokemonRepository pokemonRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public Optional<Entrenador> getEntrenadorByUuid(String uuid) {
        return entrenadorRepository.findByUuid(uuid);
    }

    public Optional<Pokemon> getPokemonByUuid(String uuid) {
        return pokemonRepository.findByUuid(uuid);
    }

    public void agregarPokemonAEntrenador(String entrenadorUuid, String pokemonUuid) {
        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findByUuid(entrenadorUuid);
        Optional<Pokemon> pokemonOptional = pokemonRepository.findByUuid(pokemonUuid);

        entrenadorOptional.ifPresent(entrenador -> {
            pokemonOptional.ifPresent(pokemon -> {
                entrenador.agregarPokemon(pokemon); // Asegúrate de tener un método similar en tu entidad Entrenador
                entrenadorRepository.save(entrenador);
            });
        });
    }

    

    public Optional<Entrenador> getEntrenadorByUuid1(String uuid) {
        return entrenadorRepository.findByUuid(uuid);
    }

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> getEntrenadorById(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador addEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador updateEntrenador(Long id, Entrenador entrenador) {
        Optional<Entrenador> existingEntrenadorOptional = entrenadorRepository.findById(id);
        if (existingEntrenadorOptional.isPresent()) {
            Entrenador existingEntrenador = existingEntrenadorOptional.get();
          
            existingEntrenador.setNombre(entrenador.getNombre());
            
            return entrenadorRepository.save(existingEntrenador);
        } else {
            return null; 
        }
    }

    public boolean deleteEntrenador(Long id) {
        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findById(id);
        if (entrenadorOptional.isPresent()) {
            entrenadorRepository.deleteById(id);
            return true;
        } else {
            return false; 
        }
    }
    
    
    public static Optional<String> loginEntrenador(String email, String contraseña) {
        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findByEmailAndPassword(email, contraseña);
        return entrenadorOptional.map(Entrenador::getUuid);
    }
}
