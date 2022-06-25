package springresttemplate.domain.VOs;

import lombok.Data;

@Data
public class PokemonTypesVO {
    private Integer slot;
    private PokemonTypeInfoVO type;
}
