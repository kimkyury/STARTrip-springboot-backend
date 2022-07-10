package STARTrip.WeatherScoreDeamon.domain.koreaTownInfo;

import com.sun.istack.NotNull;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "korea_town_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KoreaTownInfo {

    @Id
    @Column(name = "areacode")
    private UUID id;

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
