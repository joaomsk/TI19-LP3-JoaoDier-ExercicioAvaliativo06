package springresttemplate.Service.Interfaces;

import springresttemplate.Service.DTOs.PokemonDTO;

public interface IPokemonService {
    PokemonDTO getPokemonById(int idPokemon);
    PokemonDTO getPokemonByName(String pokemonName);
}
