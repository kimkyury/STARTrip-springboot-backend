package STARTrip.WeatherScoreDeamon.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScoreScheduler {


    @Scheduled(fixedRate = 1000) //1분 간격 설정
    public void weatherScoreScheduler(){




    }

}
