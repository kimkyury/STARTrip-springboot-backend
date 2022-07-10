package STARTrip.WeatherScoreDeamon.domain.weatherscoreByTown;

import STARTrip.WeatherScoreDeamon.domain.weatherscore.Weatherscore;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherscoreByTownRepository extends JpaRepository<WeatherscoreByTown, UUID> {
    Optional<Weatherscore> findByPlaceId(UUID placeId);
}
