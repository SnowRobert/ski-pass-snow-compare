package snow.pass.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualSnowfallData {
    private ActualSnowfall[] data;

    public ActualSnowfallData() {}

    public ActualSnowfall[] getData() {
        return this.data;
    }

    public void setData(ActualSnowfall[] data) {
        this.data = data;
    }
}
