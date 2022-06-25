package springresttemplate.domain.VOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class PokemonVO {
    private Integer id;
    private String name;
    private Integer weight;
    private Integer height;
    private PokemonSpritesVO sprites;
    private Collection<PokemonMovesVO> moves;
    private Collection<PokemonTypesVO> types;
}
