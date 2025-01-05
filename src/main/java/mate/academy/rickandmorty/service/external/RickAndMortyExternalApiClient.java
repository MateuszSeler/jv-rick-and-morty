package mate.academy.rickandmorty.service.external;

import mate.academy.rickandmorty.dto.internal.CartoonCharacterCreateRequestDto;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterDto;

import java.util.List;

public interface RickAndMortyExternalApiClient {
    CartoonCharacterCreateRequestDto uploadCartoonCharacterById(Long characterId);

    void uploadDataBase();
}
