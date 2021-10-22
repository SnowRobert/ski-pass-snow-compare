package snow.pass.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {
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

    private String datetime;
    private double temp;
    private double min_temp;
    private double high_temp;
    private double snow;
    private double snow_depth;
    private byte pop;
    private double wind_gust_spd;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getHigh_temp() {
        return high_temp;
    }

    public void setHigh_temp(double high_temp) {
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

    public double getWind_gust_spd() {
        return wind_gust_spd;
    }

    public void setWind_gust_spd(double wind_gust_spd) {
        this.wind_gust_spd = wind_gust_spd;
    }
}
