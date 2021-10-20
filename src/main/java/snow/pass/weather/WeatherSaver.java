package snow.pass.weather;

import org.springframework.stereotype.Controller;

import snow.pass.resorts.Resort;

import java.lang.Iterable;


@Controller 
public class WeatherSaver {

    public void checkResortList(Iterable<Resort> resortList) {
        for (Resort resort : resortList) {
            System.out.println(resort.getName());
            System.out.println(resort.getLatitude());
            System.out.println(resort.getLongitude());
        }
    }
}
