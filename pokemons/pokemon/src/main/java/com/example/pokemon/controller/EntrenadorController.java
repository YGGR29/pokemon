package com.example.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pokemon.entities.Entrenador;
import com.example.pokemon.entities.Pokemon;
import com.example.pokemon.services.EntrenadorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entrenador")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public ResponseEntity<List<Entrenador>> getAllEntrenadores() {
        List<Entrenador> entrenadores = entrenadorService.getAllEntrenadores();
        return new ResponseEntity<>(entrenadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Long id) {
        Optional<Entrenador> entrenador = entrenadorService.getEntrenadorById(id);
        return entrenador.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Entrenador> addEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador createdEntrenador = entrenadorService.addEntrenador(entrenador);
        return new ResponseEntity<>(createdEntrenador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Entrenador updatedEntrenador = entrenadorService.updateEntrenador(id, entrenador);
        return updatedEntrenador != null
                ? new ResponseEntity<>(updatedEntrenador, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        boolean deleted = entrenadorService.deleteEntrenador(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{uuid}/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemonesByEntrenador(@PathVariable String uuid) {
        Optional<Entrenador> entrenadorOptional = entrenadorService.getEntrenadorByUuid(uuid);

        return (ResponseEntity<List<Pokemon>>) entrenadorOptional.map(entrenador -> new ResponseEntity<>(entrenador.getPokemon(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/{entrenadorUuid}/pokemons/{pokemonUuid}")
    public ResponseEntity<String> agregarPokemonAEntrenador(
            @PathVariable String entrenadorUuid,
            @PathVariable String pokemonUuid
    ) {
        entrenadorService.agregarPokemonAEntrenador(entrenadorUuid, pokemonUuid);
        return new ResponseEntity<>("Pokémon agregado exitosamente al entrenador", HttpStatus.OK);
    }
}