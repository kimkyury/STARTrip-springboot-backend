package STARTrip.WeatherScoreDeamon.service;

import STARTrip.WeatherScoreDeamon.domain.place.Place;
import STARTrip.WeatherScoreDeamon.domain.place.PlaceRepository;
import STARTrip.WeatherScoreDeamon.domain.weatherscore.Weatherscore;
import STARTrip.WeatherScoreDeamon.domain.weatherscore.WeatherscoreRepository;
import STARTrip.WeatherScoreDeamon.dto.WeatherscoreDto;
import STARTrip.WeatherScoreDeamon.util.weather.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeatherScoreService {
    private final PlaceRepository placeRepository;
    private final WeatherscoreRepository weatherscoreRepository;

    private WeatherApi weatherapi;
    private final List<Place> resultPlaces = new ArrayList<>();
    private String weatherScore;
    private String userWeather;

    private String currentLongitude;
    private String currentLatitude;
    private String currentPlaceName;
    private UUID currentPlaceId;

    @Autowired
    public WeatherScoreService(PlaceRepository placeRepository, WeatherscoreRepository weatherscoreRepository){
        this.placeRepository = placeRepository;
        this.weatherscoreRepository = weatherscoreRepository;
    }

    public void setWeatherPlace() {
        List<Place> places = placeRepository.findAll();
        for (Place place : places) {
            currentLatitude =  String.valueOf(place.getLatitude());
            try{
                currentLongitude = String.valueOf(place.getLongitude());
            } catch(NullPointerException e){
                currentLongitude = "0.000000";
            }
            currentPlaceId = place.getId();
            currentPlaceName = place.getPlaceName();

            try {
                weatherScore = weatherapi.getApiResult(currentLatitude, currentLongitude);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                continue;
            }

            if (weatherScore.equals(userWeather)) {
                resultPlaces.add(place);
            }
        }
    }

    public void createWeatherScore(Place place) {
        // 생성될 때: 최초의 지역에 대하여 score를 계산할 때
        // 1시간마다 database에 있는 place의 날씨를 조회할 때, 그 placeId를 가지는 weatherSCore가 없으면 작동

        WeatherscoreDto dto = new WeatherscoreDto();
        dto.setLatitude(Double.valueOf(currentLatitude));
        dto.setLongitude(Double.valueOf(currentLongitude));
        dto.setPlaceId(currentPlaceId);
        dto.setPlaceName(currentPlaceName);

        Weatherscore weatherscore = Weatherscore.of(dto);
    }

    public void updateWeatherScore(UUID weatherscoreId, String score){
        // 1시간마다 database에 있는 place의 날씨를 조회할 때마다 변동
        weatherscoreRepository.findById(weatherscoreId)
                .orElseThrow(() -> new RuntimeException("해당 weatherscore은 존재하지 않습니다"));
        Weatherscore weatherscore = getWeatherscore(weatherscoreId);
        weatherscore.updateScore(score);
        weatherscoreRepository.save(weatherscore);
    }

    public Weatherscore getWeatherscore(UUID weatherscoreId){
        Optional<Weatherscore> weatherscore = weatherscoreRepository.findById(weatherscoreId);
        if(weatherscore.isEmpty()) {
            throw new RuntimeException("해당 weatherscore가 없습니다.");
        }
        return weatherscore.get();
    }


    public void updateSchduler(){


    }


}
