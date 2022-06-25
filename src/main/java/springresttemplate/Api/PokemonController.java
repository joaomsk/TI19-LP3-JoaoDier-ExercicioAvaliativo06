package springresttemplate.Api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springresttemplate.Service.DTOs.PokemonDTO;
import springresttemplate.Service.Interfaces.IPokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final IPokemonService pokemonService;

    public PokemonController(IPokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> pokemonById(@PathVariable int id) {
        PokemonDTO response = pokemonService.getPokemonById(id);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonDTO> pokemonById(@PathVariable String name) {
        PokemonDTO response = pokemonService.getPokemonByName(name);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
