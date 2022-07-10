package STARTrip.WeatherScoreDeamon.domain.weatherscoreByTown;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherscoreByTownRepository extends JpaRepository<WeatherscoreByTown, UUID> {

}
