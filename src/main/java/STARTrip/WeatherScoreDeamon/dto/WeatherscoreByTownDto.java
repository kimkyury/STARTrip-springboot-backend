package STARTrip.WeatherScoreDeamon.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherscoreByTownDto {

    @NotNull
    private String cityName;
    private String weatherScore;

}
