package snow.pass.repository;

import org.springframework.data.repository.CrudRepository;

import snow.pass.model.Weather;

public interface WeatherRepository extends CrudRepository<Weather, String> {
    
}
