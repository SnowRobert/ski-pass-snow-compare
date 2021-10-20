package snow.pass.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherType {

  private int code;

  public WeatherType() {
  }

  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
      this.code = code;
  }
}
