package snow.pass.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private DailyWeather[] data;

    public WeatherData() {
    }

    public DailyWeather[] getData() {
        return data;
    }

    public void setDailyWeather(DailyWeather[] data) {
        this.data = data;
    }
}
