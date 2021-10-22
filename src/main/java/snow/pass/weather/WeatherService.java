package snow.pass.weather;

import org.springframework.stereotype.Service;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
    private Dotenv dotenv = Dotenv.load();

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getWeather(double longitude, double latitude) {
        String lat = Double.toString(latitude);
        String lon = Double.toString(longitude);
        return this.restTemplate.getForObject("https://api.weatherbit.io/v2.0/forecast/daily?&lat={latitude}&lon={longitude}&key=" + dotenv.get("API_KEY"), WeatherData.class, lat, lon);
    }
}
