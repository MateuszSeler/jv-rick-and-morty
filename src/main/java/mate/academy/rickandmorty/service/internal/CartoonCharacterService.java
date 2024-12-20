package mate.academy.rickandmorty.service.internal;

import mate.academy.rickandmorty.dto.external.CartoonCharacterInputDataDto;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterCreateRequestDto;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterDto;
import mate.academy.rickandmorty.model.CartoonCharacter;

public interface CartoonCharacterService {
    CartoonCharacter save(CartoonCharacterCreateRequestDto cartoonCharacterCreateRequestDto);
}
