package mate.academy.rickandmorty.service.internal;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CartoonCharacterCreateRequestDto;
import mate.academy.rickandmorty.mapper.CartoonCharacterMapper;
import mate.academy.rickandmorty.model.CartoonCharacter;
import mate.academy.rickandmorty.repository.CartoonCharacterRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartoonCharacterServiceImpl implements CartoonCharacterService {
    private final CartoonCharacterRepository cartoonCharacterRepository;
    private final CartoonCharacterMapper cartoonCharacterMapper;
    private final EpisodeService episodeService;
    private final LocationService locationService;

    @Override
    public CartoonCharacter save(
            CartoonCharacterCreateRequestDto cartoonCharacterCreateRequestDto) {

        if (cartoonCharacterRepository.findByExternalId(
                cartoonCharacterCreateRequestDto.getExternalId()).isPresent()) {
            return cartoonCharacterRepository.findByExternalId(
                    cartoonCharacterCreateRequestDto.getExternalId()).get();
        }

        CartoonCharacter cartoonCharacter
                = cartoonCharacterMapper.toModel(cartoonCharacterCreateRequestDto);
        cartoonCharacter.setEpisodes(
                episodeService.save(cartoonCharacterCreateRequestDto.getEpisodes()));
        cartoonCharacter.setOrigin(
                locationService.save(cartoonCharacterCreateRequestDto.getOrigin()));
        cartoonCharacter.setLocation(
                locationService.save(cartoonCharacterCreateRequestDto.getLocation()));

        if (cartoonCharacterRepository.findByName(
                cartoonCharacter.getName()).isPresent()) {
            cartoonCharacter.setId(
                    cartoonCharacterRepository
                            .findByName(cartoonCharacter.getName()).get().getId()
            );
        }
        return cartoonCharacterRepository.save(cartoonCharacter);
    }
}
