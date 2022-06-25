package springresttemplate.Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonTypesDTO {
    private Integer slot;
    private String name;
}
