package mate.academy.rickandmorty.service.internal;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.EpisodeCreateRequestDto;
import mate.academy.rickandmorty.mapper.EpisodeMapper;
import mate.academy.rickandmorty.model.Episode;
import mate.academy.rickandmorty.repository.EpisodeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final EpisodeMapper episodeMapper;

    @Override
    public List<Episode> save(List<EpisodeCreateRequestDto> episodesCreateRequestDtos) {
        List<Episode> episodes = episodesCreateRequestDtos
                .stream()
                .map(episodeMapper::toModel)
                .toList();
        return episodeRepository.saveAll(episodes);
    }
}
