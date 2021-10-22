package snow.pass.weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
