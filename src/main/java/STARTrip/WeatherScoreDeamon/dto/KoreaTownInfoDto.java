package STARTrip.WeatherScoreDeamon.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KoreaTownInfoDto {

    @NotNull
    private String step1;

    private String seep2;
    private String step3;

    @NotNull
    private String gridX;

    @NotNull
    private String gridY;

    @NotNull
    private String longitudeHour;

    @NotNull
    private String latitudeHour;

    @NotNull
    private String longitudeMin;

    @NotNull
    private String latitudeMin;

    @NotNull
    private String longitudeSec;

    @NotNull
    private String latitudeSec;

    @NotNull
    private String longitudeMs;

    @NotNull
    private String latitudeMs;

}
