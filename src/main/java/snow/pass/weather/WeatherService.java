package snow.pass.weather;

import org.springframework.stereotype.Service;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
    private Dotenv dotenv = Dotenv.load();

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getWeather(double longitude, double latitude) {
        return this.restTemplate.getForObject("https://api.weatherbit.io/v2.0/forecast/daily?&lat={latitude}&lon={longitude}&key=" + dotenv.get("API_KEY"), WeatherData.class, latitude, longitude);
    }
}
