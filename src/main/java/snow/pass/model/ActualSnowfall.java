package snow.pass.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualSnowfall {
    private double snow;
    private String date_snowfall;
    private String name;

    public ActualSnowfall() {}

    public double getSnow() {
        return this.snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    public String getDate_snowfall() {
        return this.date_snowfall;
    }

    public void setDate_snowfall(String date) {
        this.date_snowfall = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
