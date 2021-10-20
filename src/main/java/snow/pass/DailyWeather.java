package snow.pass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWeather {

  private String datetime;//
  private float temp;
  private float min_temp;
  private float high_temp;
  private double snow;
  private double snow_depth;
  private byte pop;
  private float wind_gust_spd;
  private WeatherType weather_type;

  public DailyWeather() {
  }

  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public float getTemp() {
    return temp;
  }

  public void setTemp(float temp) {
    this.temp = temp;
  }

  public float getMin_temp() {
    return min_temp;
  }

  public void setMin_temp(float min_temp) {
    this.min_temp = min_temp;
  }

  public float getHigh_temp() {
    return high_temp;
  }

  public void setHigh_temp(float high_temp) {
    this.high_temp = high_temp;
  }

  public double getSnow() {
    return snow;
  }

  public void setSnow(double snow) {
    this.snow = snow;
  }

  public double getSnow_depth() {
    return snow_depth;
  }

  public void setSnow_depth(double snow_depth) {
    this.snow_depth = snow_depth;
  }

  public byte getPop() {
    return pop;
  }

  public void setPop(byte pop) {
    this.pop = pop;
  }

  public float getWind_gust_spd() {
    return wind_gust_spd;
  }

  public void setWind_gust_spd(float wind_gust_spd) {
    this.wind_gust_spd = wind_gust_spd;
  }

  public WeatherType getWeather() {
    return weather_type;
  }

  public void setWeather(WeatherType weather_type) {
    this.weather_type = weather_type;
  }

}
