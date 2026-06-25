package com.finfactor.pokemon.controller;

import com.finfactor.pokemon.dto.PokemonAPIResponseDTO;
import com.finfactor.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    @GetMapping("/{name}")
    public PokemonAPIResponseDTO getPokemon(@PathVariable String name){
        return pokemonService.getPokemon(name);
    }

}
