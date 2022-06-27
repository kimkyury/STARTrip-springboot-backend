package STARTrip.WeatherScoreDeamon.domain.weatherInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirPollutionInfo {

    private String informCode;
    private String informData;
    private String dataTime;
    private String informGrade;
}
