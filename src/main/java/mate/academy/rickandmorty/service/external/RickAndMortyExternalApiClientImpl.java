package mate.academy.rickandmorty.service.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CartoonCharacterInputDataDto;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterCreateRequestDto;
import mate.academy.rickandmorty.mapper.CartoonCharacterMapper;
import mate.academy.rickandmorty.model.CartoonCharacter;
import mate.academy.rickandmorty.service.internal.CartoonCharacterService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RickAndMortyExternalApiClientImpl implements RickAndMortyExternalApiClient {
    private static final int NUMBER_OF_CHARACTERS = 826;
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character/";
    private static final String SEPARATOR = "?";
    private final CartoonCharacterService cartoonCharacterService;
    private final CartoonCharacterMapper cartoonCharacterMapper;
    private final ObjectMapper mapper;
    private final Random random = new Random();

    //  + ?name=rick&status=alive
    /*
    name: filter by the given name.
    status: filter by the given status (alive, dead or unknown).
    species: filter by the given species.
    type: filter by the given type.
    gender: filter by the given gender (female, male, genderless or unknown).
     */
    @Override
    public CartoonCharacter getRandomCharacter() {
        return getCharacterById(random.nextLong(NUMBER_OF_CHARACTERS));
    }

    @Override
    public CartoonCharacter getCharacterById(Long characterId) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = BASE_URL + characterId;

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            CartoonCharacterCreateRequestDto newCartoonCharacterCreateRequestDto =
                    cartoonCharacterMapper.toModel(
                            mapper.readValue(response.body(), CartoonCharacterInputDataDto.class));

            return cartoonCharacterService.save(newCartoonCharacterCreateRequestDto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
