package mate.academy.rickandmorty.service.external;

import mate.academy.rickandmorty.model.CartoonCharacter;

public interface RickAndMortyExternalApiClient {
    CartoonCharacter getRandomCharacter();

    CartoonCharacter getCharacterById(Long characterId);
}
