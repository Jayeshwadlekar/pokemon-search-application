package com.finfactor.pokemon.service;

import com.finfactor.pokemon.client.PokeApiClient;
import com.finfactor.pokemon.dto.PokemonAPIResponseDTO;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


@Service
public class PokemonService {
    private static final Logger logger=
            LoggerFactory.getLogger(PokemonService.class);
    private final PokeApiClient pokeApiClient;

    public PokemonService(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }
    @Cacheable(value = "pokemonCache", key = "#name.trim().toLowerCase()")
    public PokemonAPIResponseDTO getPokemon(String name) {
        name = name.trim().toLowerCase();
        logger.info("Fetching Pokemon: {}", name);
        return pokeApiClient.fetchPokemon(name);

    }

}
