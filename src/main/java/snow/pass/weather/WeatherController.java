package snow.pass.weather;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping(path="/make-weather")
    public @ResponseBody String addResortWeather() {
        WeatherService weatherService = new WeatherService();

        Iterable<Resort> resorts = resortRepository.findAll();
        for (Resort resort : resorts) {

            WeatherData weatherData = weatherService.getWeather(resort.getLongitude(), resort.getLatitude());
            DailyWeather[] dailyWeather = weatherData.getData();
            
            for (DailyWeather w : dailyWeather) {
                Weather weather = new Weather(resort.getId(), w.getDatetime());   
                weather.setWeather_code(w.getWeather_code());
                weather.setTemp(w.getTemp());
                weather.setMin_temp(w.getMin_temp());
                weather.setHigh_temp(w.getHigh_temp());
                weather.setSnow(w.getSnow());
                weather.setSnow_depth(w.getSnow_depth());
                weather.setPop(w.getPop());
                weather.setWind_gust_spd(w.getWind_gust_spd());

                weatherRepository.save(weather);
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.err.format("IOException: %s%n", e);
            }
        }
        return "Resort weather saved";
    }

    @GetMapping(path="/weather/{id}")
    public @ResponseBody Weather addResortWeather(@PathVariable String id) {
        String dateId = id + "-" + java.time.LocalDate.now();
        return weatherRepository.findById(dateId)
            .orElseThrow(() -> new RuntimeException(id));
    }

        // @GetMapping(path="/weather")
    // public @ResponseBody WeatherData getWeather() {
    //     WeatherService w = new WeatherService();
    //     return w.getWeather(-121.089, 47.746);
    // }

    // @GetMapping(path="/weather/{id}")
    // public @ResponseBody String addResortWeather(@PathVariable String id) {
    //     WeatherService weatherService = new WeatherService();

    //     Optional<Resort> optionalResort = resortRepository.findById(id);
    //     optionalResort.ifPresent(resort -> {
    //         WeatherData weatherData = weatherService.getWeather(resort.getLongitude(), resort.getLatitude());
    //         DailyWeather[] dailyWeather = weatherData.getData();
            
    //         for (DailyWeather w : dailyWeather) {
    //             Weather weather = new Weather(resort.getId(), w.getDatetime());   
    //             weather.setWeather_code(w.getWeather_code());
    //             weather.setTemp(w.getTemp());
    //             weather.setMin_temp(w.getMin_temp());
    //             weather.setHigh_temp(w.getHigh_temp());
    //             weather.setSnow(w.getSnow());
    //             weather.setSnow_depth(w.getSnow_depth());
    //             weather.setPop(w.getPop());
    //             weather.setWind_gust_spd(w.getWind_gust_spd());

    //             weatherRepository.save(weather);
    //         }
    //     });
    //     return "Resort weather saved";
    // }
}
