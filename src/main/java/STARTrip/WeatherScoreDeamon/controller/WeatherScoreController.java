package STARTrip.WeatherScoreDeamon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherScoreController {

    @GetMapping("weatherscore")
    public String hello(Model model){
        model.addAttribute("data","hello, it is testPage");
        return "weatherscore"; // templates에서 연결할 html의 이름
    }
}

