package STARTrip.WeatherScoreDeamon.domain.weatherscore;

import STARTrip.WeatherScoreDeamon.dto.WeatherscoreDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Weatherscore {

    @Id
    @Column(name = "weatherscore_id")
    private UUID id;

    @JoinColumn(name = "place_id")
    @Column(name = "place_id")
    private UUID placeId;

    @Column(name = "place_name")
    private String placeName;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    private String score;

    public static Weatherscore of (WeatherscoreDto dto){
        return  Weatherscore.builder()
                .id(UUID.randomUUID())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .score(dto.getScore())
                .build();
    }

    public void update(WeatherscoreDto dto) {
        this.placeId = dto.getPlaceId();
        this.placeName = dto.getPlaceName();
        this.latitude = dto.getLatitude();
        this.longitude = dto.getLongitude();
    }

    public void updateScore (String dto){
        this.score = dto.getScore();
    }
}