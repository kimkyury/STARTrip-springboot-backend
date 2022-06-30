package STARTrip.WeatherScoreDeamon.controller;

import STARTrip.WeatherScoreDeamon.domain.place.Place;
import STARTrip.WeatherScoreDeamon.domain.place.PlaceRepository;
import STARTrip.WeatherScoreDeamon.util.weather.WeatherApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class WeatherScoreController {

    private final PlaceRepository placeRepository;
    private WeatherApi weatherapi;

    @Autowired
    public WeatherFilterService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    private final List<Place> resultPlaces = new ArrayList<>();
    private String weatherScore;
    private String userWeather;

    @Override
    public CurationObject process(CurationObject input) {
        Object object = input.userInput.get(ChainType.WEATHER);
        if (object instanceof String) {
            userWeather = (String) object;
            setWeatherPlace();  // key: 지역명, value: 지역별 오늘자 날씨판별
            for(Place place:resultPlaces){
                UUID placeId = place.getId();
                input.booleanBuilder.or(QPlace.place.id.eq(placeId));
            }
        }
        return input;
    }

    public void setWeatherPlace() {
        List<Place> places = placeRepository.findAll();
        for (Place place : places) {
            String x = String.valueOf(place.getLatitude());
            String y;
            try{
                y = String.valueOf(place.getLongitude());
            } catch(NullPointerException e){
                y = "0.000000";
            }

            try {
                weatherScore = weatherapi.getApiResult(x, y);
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


}
