package mate.academy.rickandmorty.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class CartoonCharacterInputDataDto {
    @JsonProperty("id")
    private Long externalId;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationInputDataDto origin;
    private LocationInputDataDto location;
    private String image;
    @JsonProperty("episode")
    private List<String> episodes;
    private String url;
    private LocalDateTime created;
}

/*
  "id": 2,
  "name": "Morty Smith",
  "status": "Alive",
  "species": "Human",
  "type": "",
  "gender": "Male",
  "origin": Location
  "location": Location
  "image": "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
  "episode": List<Episode>
  "url": "https://rickandmortyapi.com/api/character/2",
  "created": "2017-11-04T18:50:21.651Z"
 */
