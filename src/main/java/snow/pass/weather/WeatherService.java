package snow.pass.weather;

import org.springframework.stereotype.Service;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;


@Service
public class WeatherService {
    private Dotenv dotenv = Dotenv.load();

    private final RestTemplate restTemplate = new RestTemplate();

    // public WeatherService(RestTemplateBuilder restTemplateBuilder) {
    //     this.restTemplate = restTemplateBuilder.build();
    // }

    public Weather getWeather(double longitude, double latitude) {
        return this.restTemplate.getForObject("https://api.weatherbit.io/v2.0/forecast/daily?&lat={latitude}&lon={longitude}&key=" + dotenv.get("API_KEY"), Weather.class, latitude, longitude);
    }
}
