package snow.pass.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWeather extends WeatherParent {

  private WeatherType weather_type;

  public DailyWeather() {
  }

  public void setWeather(WeatherType weather_type) {
    this.weather_type = weather_type;
  }

  public int getWeather_code() {
    return this.weather_type.getCode();
  }
}
