package snow.pass.taskconfig;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import snow.pass.model.DailyWeather;
import snow.pass.model.Resort;
import snow.pass.model.Weather;
import snow.pass.model.WeatherData;
import snow.pass.repository.ResortRepository;
import snow.pass.repository.WeatherRepository;
import snow.pass.service.WeatherService;

@Component
public class GetDailyWeatherTask {
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private ResortRepository resortRepository;

    @Scheduled(cron = "0 0 6 * * *",  zone = "UTC")
    public void getDailyWeatherTask() {
        System.out.println("Saving Daily Weather");

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

        System.out.println("Daily Weather Saved! (Probably)");
    }
}
