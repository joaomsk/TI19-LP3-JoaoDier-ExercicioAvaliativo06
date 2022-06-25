package springresttemplate.Service.DTOs;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Builder
@Data
public class PokemonDTO {
    private Integer id;
    private String name;
    private Integer weight;
    private Integer heigth;
    private String sprites;
    private Collection<PokemonMovesDTO> moves;
    private Collection<PokemonTypesDTO> types;
}
