package mate.academy.rickandmorty.service.internal;

import mate.academy.rickandmorty.dto.internal.CartoonCharacterCreateRequestDto;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterDto;
import mate.academy.rickandmorty.model.CartoonCharacter;

import java.util.Optional;

public interface CartoonCharacterService {
    CartoonCharacter save(CartoonCharacterCreateRequestDto cartoonCharacterCreateRequestDto);

    CartoonCharacterDto getCartoonCharacter(Long id);

    CartoonCharacterDto getRandomCartoonCharacter();
}
