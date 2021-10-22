package snow.pass.resorts;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resort {
    @Id
    private String id;
    private String name;
    private String state;
    private String pass;
    private double latitude;
    private double longitude;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getPass() {
        return pass;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
