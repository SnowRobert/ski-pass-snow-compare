package snow.pass.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import snow.pass.model.ActualSnowfall;
import snow.pass.model.ActualSnowfallData;
import snow.pass.model.DailyWeather;
import snow.pass.model.Resort;
import snow.pass.model.Weather;
import snow.pass.model.WeatherData;
import snow.pass.model.WeatherRecord;
import snow.pass.repository.ResortRepository;
import snow.pass.repository.WeatherRecordRepository;
import snow.pass.repository.WeatherRepository;
import snow.pass.service.WeatherService;

@Configuration
@Controller
@RequestMapping(path="/api")
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherRecordRepository weatherRecordRepository;

    @Autowired
    private ResortRepository resortRepository;

    @GetMapping(path="/make-weather")
    public @ResponseBody String addResortWeather() {
        WeatherService weatherService = new WeatherService();

        Iterable<Resort> resorts = resortRepository.findAll();
        for (Resort resort : resorts) {

            WeatherData weatherData = weatherService.getWeather(resort.getLongitude(), resort.getLatitude());
            DailyWeather[] dailyWeather = weatherData.getData();

            WeatherRecord weatherRecord = new WeatherRecord(resort.getId(), dailyWeather[0].getDatetime(), dailyWeather[0].getSnow(),
                dailyWeather[1].getSnow(), dailyWeather[2].getSnow(), dailyWeather[4].getSnow(), dailyWeather[6].getSnow(),
                dailyWeather[9].getSnow(), dailyWeather[15].getSnow());

            weatherRecordRepository.save(weatherRecord);
      
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

    @PostMapping(value = "/weather/add-actual-snowfall", consumes = "application/json", produces = "application/json")
        public String createPerson(@RequestBody ActualSnowfallData snowfallData) {
            ActualSnowfall[] actualSnowfall = snowfallData.getData();
            for (ActualSnowfall snowfall : actualSnowfall) {
                String resortId = snowfall.getName() + "-" + snowfall.getDate_snowfall();
                Optional<WeatherRecord> optionalRecord = weatherRecordRepository.findById(resortId);
                optionalRecord.ifPresent(record -> {
                    record.setActual_snow_inches(snowfall.getSnow());
                    weatherRecordRepository.save(record);
                });
            }
            return "Snowfall Data Saved";
        }

}
