package com.finfactor.pokemon.client;

import com.finfactor.pokemon.dto.PokemonAPIResponseDTO;
import com.finfactor.pokemon.exception.PokemonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiClient {

    private static final Logger logger =
            LoggerFactory.getLogger(PokeApiClient.class);
    private final RestTemplate restTemplate;

    public PokeApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokemonAPIResponseDTO fetchPokemon(String name) {
        logger.info("Calling PokeAPI for Pokemon: {}", name);
        String url = "https://pokeapi.co/api/v2/pokemon/{name}";
        try {
            PokemonAPIResponseDTO response = restTemplate.getForObject(url, PokemonAPIResponseDTO.class, name);
            logger.info("Successfully fetched Pokemon: {}", name);
            return response;
        } catch (HttpClientErrorException.NotFound e) {
            logger.error("Pokemon not found: {}", name);
            throw new PokemonNotFoundException(
                    "Pokemon not found: " + name);
        }

    }

}
