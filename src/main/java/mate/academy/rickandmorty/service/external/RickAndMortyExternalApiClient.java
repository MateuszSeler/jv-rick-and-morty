package mate.academy.rickandmorty.service.external;

import mate.academy.rickandmorty.dto.external.CartoonCharacterInputDataDto;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterDto;

public interface RickAndMortyExternalApiClient {
    CartoonCharacterDto getCharacterById(Long characterId);
}
