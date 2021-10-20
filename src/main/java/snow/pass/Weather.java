package snow.pass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private DailyWeather[] data;

    public Weather() {
    }

    public DailyWeather[] getData() {
        return data;
    }

    public void setDailyWeather(DailyWeather[] data) {
        this.data = data;
    }
}
