package snow.pass.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WeatherRecord {
    @Id
    private String id;
    private String resort_id;
    private String datetime;
    private double one_day_snow;
    private double two_day_snow;
    private double three_day_snow;
    private double five_day_snow;
    private double seven_day_snow;
    private double ten_day_snow;
    private double sixteen_day_snow;

    public WeatherRecord() {}

    public WeatherRecord(String resort_id, String datetime, double one_day_snow, double two_day_snow,
    double three_day_snow, double five_day_snow, double seven_day_snow, double ten_day_snow, double sixteen_day_snow) {
        this.resort_id = resort_id;
        this.setDatetime(datetime);
        this.id = resort_id + "-" + datetime;
        this.one_day_snow = one_day_snow;
        this.two_day_snow = two_day_snow;
        this.three_day_snow = three_day_snow;
        this.five_day_snow = five_day_snow;
        this.seven_day_snow = seven_day_snow;
        this.ten_day_snow = ten_day_snow;
        this.sixteen_day_snow = sixteen_day_snow;
    }

    public String getId() {
        return this.id;
    }

    public String getResort_id() {
        return this.resort_id;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getOne_day_snow() {
        return this.one_day_snow;
    }

    public void setOne_day_snow(double snow) {
        this.one_day_snow = snow;
    }

    public double getTwo_day_snow() {
        return this.two_day_snow;
    }

    public void setTwo_day_snow(double snow) {
        this.two_day_snow = snow;
    }

    public double getThree_day_snow() {
        return this.three_day_snow;
    }

    public void setThree_day_snow(double snow) {
        this.three_day_snow = snow;
    }

    public double getFive_day_snow() {
        return this.five_day_snow;
    }

    public void setFive_day_snow(double snow) {
        this.five_day_snow = snow;
    }

    public double getSeven_day_snow() {
        return this.seven_day_snow;
    }

    public void setSeven_day_snow(double snow) {
        this.seven_day_snow = snow;
    }

    public double getTen_day_snow() {
        return this.ten_day_snow;
    }

    public void setTen_day_snow(double snow) {
        this.ten_day_snow = snow;
    }

    public double getSixteen_day_snow() {
        return this.sixteen_day_snow;
    }

    public void setSixteen_day_snow(double snow) {
        this.sixteen_day_snow = snow;
    }
}
