package com.finfactor.pokemon.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonAPIResponseDTO {


    private String name;

    private Integer height;

    private Integer weight;

    private Sprites sprites;

    private List<TypeWrapper> types;

    private List<AbilityWrapper> abilities;
    private List<Stat> stats;


    @Data
    public static class Sprites {
        private String front_default;
    }


    @Data
    public static class TypeWrapper {
        private Type type;
    }

    @Data
    public static class Type {
        private String name;
    }


    @Data
    public static class AbilityWrapper {
        private Ability ability;
    }

    @Data
    public static class Ability {
        private String name;
    }
    @Data
    public static class Stat {

        private int base_stat;

        private StatInfo stat;
    }
    @Data
    public static class StatInfo {

        private String name;
    }

}