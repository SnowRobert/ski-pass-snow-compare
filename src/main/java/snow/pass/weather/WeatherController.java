package snow.pass.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class WeatherController {
    
    @GetMapping(path="/weather")
    public @ResponseBody Weather getWeather() {
        WeatherService w = new WeatherService();
        return w.getWeather(47.746, -121.089);
    }
}
