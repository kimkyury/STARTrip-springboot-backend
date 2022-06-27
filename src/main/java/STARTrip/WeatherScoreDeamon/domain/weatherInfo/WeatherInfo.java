package STARTrip.WeatherScoreDeamon.domain.weatherInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherInfo {

    private String baseTime;
    private String fcstTime;
    private String category;
    private int fcstValue;
}
