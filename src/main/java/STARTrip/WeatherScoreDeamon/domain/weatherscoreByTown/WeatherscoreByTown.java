package STARTrip.WeatherScoreDeamon.domain.weatherscoreByTown;

import java.util.UUID;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "weatherscore_by_town")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherscoreByTown {

    @Id
    @Column(name = "city_id")
    private UUID id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "weather_score")
    private String weatherScore;


    public static WeatherscoreByTown of (Object obj){
        return WeatherscoreByTown.builder()
            .id(UUID.randomUUID())
            .cityNmae()
    }




}
