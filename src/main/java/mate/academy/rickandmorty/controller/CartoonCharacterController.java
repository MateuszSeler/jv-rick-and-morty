package mate.academy.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterDto;
import mate.academy.rickandmorty.service.external.RickAndMortyExternalApiClient;
import mate.academy.rickandmorty.service.internal.CartoonCharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/characters")
public class CartoonCharacterController {
    private final CartoonCharacterService cartoonCharacterService;
    private final RickAndMortyExternalApiClient rickAndMortyExternalApiClient;

    @GetMapping("/random")
    public CartoonCharacterDto getRandomCharacter() {
        rickAndMortyExternalApiClient.uploadDataBase();
        return cartoonCharacterService.getRandomCartoonCharacter();
    }

}
