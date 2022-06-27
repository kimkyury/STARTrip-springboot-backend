package STARTrip.WeatherScoreDeamon.domain.weatherInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivingWeatherInfo {

    private String date;
    private String areaNo;
    private String today;
    private String tomorrow;
    private String dayAfterTomorrow;
    private String twoDayAfterTomorrow;
}
