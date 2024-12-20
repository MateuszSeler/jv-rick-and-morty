package mate.academy.rickandmorty.service.internal;

import mate.academy.rickandmorty.dto.internal.EpisodeCreateRequestDto;
import mate.academy.rickandmorty.model.Episode;

import java.util.List;

public interface EpisodeService {
    List<Episode> save(List<EpisodeCreateRequestDto> episodesCreateRequestDtos);
}
