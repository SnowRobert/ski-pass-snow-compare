package snow.pass.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather extends WeatherParent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String resort_id; //foreign key
    private int weather_code;

    public Integer getId() {
        return this.id;
    }

    public String getResort_id() {
        return this.resort_id;
    }

    public void setResort_id(String resort_id) {
        this.resort_id = resort_id;
    }

    public int getWeather_code() {
        return this.weather_code;
    }

    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }
}
