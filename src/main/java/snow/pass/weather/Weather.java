package snow.pass.weather;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather extends WeatherParent {
    @Id
    private String id;
    private String resort_id; //foreign key
    private int weather_code;

    public Weather() {}

    public Weather(String resort_id, String datetime) {
        this.resort_id = resort_id;
        this.setDatetime(datetime);
        this.id = resort_id + "-" + datetime;
    }

    public String getId() {
        return this.id;
    }

    public String getResort_id() {
        return this.resort_id;
    }

    public int getWeather_code() {
        return this.weather_code;
    }

    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }
}
