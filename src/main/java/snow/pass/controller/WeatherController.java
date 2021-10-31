package snow.pass.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import snow.pass.model.Weather;
import snow.pass.repository.WeatherRepository;

@Configuration
@Controller
@RequestMapping(path="/api")
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping(path="/weather/{id}")
    public @ResponseBody ArrayList<Weather> addResortWeather(@PathVariable String id) {
        ArrayList<Weather> weatherList = new ArrayList<Weather>();
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 7; i++) {
            String dateId = id + "-" + dateFormat.format(cal.getTime());
            Optional<Weather> optionalWeather = weatherRepository.findById(dateId);
            optionalWeather.ifPresent(weather -> weatherList.add(weather));
            cal.add(Calendar.DATE, +1);
        }
        return weatherList;
    }
}
