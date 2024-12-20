package mate.academy.rickandmorty.service.internal;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.LocationCreateRequestDto;
import mate.academy.rickandmorty.dto.internal.LocationUpdateRequestDto;
import mate.academy.rickandmorty.mapper.LocationMapper;
import mate.academy.rickandmorty.model.Location;
import mate.academy.rickandmorty.repository.LocationRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public Location save(LocationCreateRequestDto locationCreateRequestDto) {

        locationMapper.toModel(locationCreateRequestDto);
        return locationRepository.save(locationMapper.toModel(locationCreateRequestDto));
    }
}
