package mate.academy.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.model.CartoonCharacter;
import mate.academy.rickandmorty.service.external.RickAndMortyExternalApiClientImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/characters")
public class CartoonCharacterController {
    private final RickAndMortyExternalApiClientImpl externalApiClientImpl;

    @GetMapping("/{id}")
    public CartoonCharacter getCharacterById(@PathVariable Long id) {
        return externalApiClientImpl.getCharacterById(id);
    }

    @GetMapping("/random")
    public CartoonCharacter getRandomCharacter() {
        return externalApiClientImpl.getRandomCharacter();
    }
}
