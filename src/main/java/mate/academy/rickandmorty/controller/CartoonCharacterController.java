package mate.academy.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.service.ExternalApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/characters")
public class CartoonCharacterController {
    private final ExternalApiClient externalApiClient;

    @GetMapping("/{id}")
    public Object getCharacterById(@PathVariable Long id) {
        return externalApiClient.getCharacterById(id);
    }
}
