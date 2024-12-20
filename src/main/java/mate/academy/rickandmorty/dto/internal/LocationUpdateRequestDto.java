package mate.academy.rickandmorty.dto.internal;

import lombok.Data;

@Data
public class LocationUpdateRequestDto {
    private Long id;
    private String name;
    private String url;
}
