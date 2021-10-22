package snow.pass.weather;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class WeatherParent {
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
