package snow.pass.weather;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import snow.pass.resorts.Resort;
import snow.pass.resorts.ResortRepository;


@Controller
@RequestMapping(path="/api")
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private ResortRepository resortRepository;
    
    @GetMapping(path="/weather")
    public @ResponseBody WeatherData getWeather() {
        WeatherService w = new WeatherService();
        return w.getWeather(47.746, -121.089);
    }

    @GetMapping(path="/weather/{id}")
    public @ResponseBody String addResortWeather(@PathVariable String id) {
        WeatherService weatherService = new WeatherService();

        Optional<Resort> optionalResort = resortRepository.findById(id);
        optionalResort.ifPresent(resort -> {
            WeatherData weatherData = weatherService.getWeather(resort.getLatitude(), resort.getLongitude());
            DailyWeather dailyWeather = weatherData.getData()[0];
            System.out.println("#@$!@$!@#$!@$!@#$@!$!@$@#$!@#$!@#$!@#$@#$!$#$hii!#@$!@#$!@#$");
            System.out.println(dailyWeather.getTemp());
            System.out.println("#@$!@$!@#$!@$!@#$@!$!@$@#$!@#$!@#$!@#$@#$!$#$hii!#@$!@#$!@#$");

            Weather weather = new Weather();   
            weather.setResort_id(resort.getId());
            weather.setWeather_code(dailyWeather.getWeather_code());
            weather.setDatetime(dailyWeather.getDatetime());
            weather.setTemp(dailyWeather.getTemp());
            System.out.println("#@$!@$!@#$!@$!@#$@!$!@$@#$!@#$!@#$!@#$@#$!$#$hii!#@$!@#$!@#$");
            System.out.println(weather.getTemp());
            System.out.println("#@$!@$!@#$!@$!@#$@!$!@$@#$!@#$!@#$!@#$@#$!$#$hii!#@$!@#$!@#$");
            weather.setMin_temp(dailyWeather.getMin_temp());
            weather.setHigh_temp(dailyWeather.getHigh_temp());
            weather.setSnow(dailyWeather.getSnow());
            weather.setSnow_depth(dailyWeather.getSnow_depth());
            weather.setPop(dailyWeather.getPop());
            weather.setWind_gust_spd(dailyWeather.getWind_gust_spd());

            weatherRepository.save(weather);
        });
        return "Resort weather saved";
    }
}
