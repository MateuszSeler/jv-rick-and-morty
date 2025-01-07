package mate.academy.rickandmorty.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterDto;
import mate.academy.rickandmorty.model.CartoonCharacter;
import mate.academy.rickandmorty.service.external.RickAndMortyExternalApiClient;
import mate.academy.rickandmorty.service.internal.CartoonCharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/islike/{string}")
    public List<CartoonCharacter> findNameIsLike(@PathVariable String string) {
        rickAndMortyExternalApiClient.uploadDataBase();
        return cartoonCharacterService.findNamesWhichContainString(string);
    }

}
