package STARTrip.WeatherScoreDeamon.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherScoreController {

    @GetMapping("weatherscore")
    public String hello(Model model){
        model.addAttribute("data","hello, it is testPage");
        return "weatherscore"; // templates에서 연결할 html의 이름
    }

    @GetMapping("hello-mvc")
    public String helloMc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name); // key: "name", value: name(파라미터로 넘어온 것)
        return "hello-template";
    }


    @GetMapping ("hello-string")
    @ResponseBody // 중요, Http의 응답 바디부에 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // 내가 요청한 client에 그대로 넘어감

        // templete과의 차이로는, view없이 그냥 그대로 넘어가는 것이다
        // 나중에 페이지 소스를 보면 알겠지만, templete코드 없이 그냥 무식하게 string만 그대로 데이터를 출력하고 있다
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}

