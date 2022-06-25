package springresttemplate.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springresttemplate.Service.DTOs.PokemonDTO;
import springresttemplate.Service.DTOs.PokemonMovesDTO;
import springresttemplate.Service.DTOs.PokemonTypesDTO;
import springresttemplate.Service.Interfaces.IPokemonService;
import springresttemplate.domain.VOs.PokemonVO;

@Service
public class PokemonService implements IPokemonService {

    @Value("${poke-api-uri}")
    private String uri;
    private final RestTemplate restTemplate;

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PokemonDTO getPokemonById(int idPokemon) {

        return getPokemonDTO(generateURLIntegration(idPokemon));
    }

    public PokemonDTO getPokemonByName(String pokemonName) {

        return getPokemonDTO(generateURLIntegration(pokemonName));
    }

    private PokemonDTO getPokemonDTO(String urlParameter) {
        PokemonVO response = this.restTemplate
                .getForObject(urlParameter,
                        PokemonVO.class);

        return PokemonDTO.builder()
                .id(response.getId())
                .name(response.getName())
                .weight(response.getWeight())
                .heigth(response.getHeight())
                .sprites(response.getSprites().getFront_default())
                .moves(response.getMoves()
                        .stream()
                        .limit(5)
                        .map(x -> new PokemonMovesDTO(x.getMove().getName()))
                        .toList())
                .types(response.getTypes()
                        .stream()
                        .map(x -> new PokemonTypesDTO(x.getSlot(), x.getType().getName()))
                        .toList())
                .build();
    }

    private String generateURLIntegration(String name) {
        return this.uri + "/" + name;
    }

    private String generateURLIntegration(int id) {
        return this.uri + "/" + id;
    }
}
