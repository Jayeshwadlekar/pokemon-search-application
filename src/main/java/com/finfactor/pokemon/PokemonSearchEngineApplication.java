package com.finfactor.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PokemonSearchEngineApplication {

	public static void main(String[] args) {

        SpringApplication.run(PokemonSearchEngineApplication.class, args);
	}

}
