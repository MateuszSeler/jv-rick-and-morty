package mate.academy.rickandmorty.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CartoonCharacterDataDto;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExternalApiClient {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character/";
    private static final String SEPARATOR = "?";
    private final ObjectMapper mapper;

    //  + ?name=rick&status=alive
    /*
    name: filter by the given name.
    status: filter by the given status (alive, dead or unknown).
    species: filter by the given species.
    type: filter by the given type.
    gender: filter by the given gender (female, male, genderless or unknown).
     */

    public CartoonCharacterDataDto getCharacterById(Long characterId) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = BASE_URL + characterId;

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), CartoonCharacterDataDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
