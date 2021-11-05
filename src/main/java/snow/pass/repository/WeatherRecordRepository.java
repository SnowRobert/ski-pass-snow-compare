package snow.pass.repository;

import org.springframework.data.repository.CrudRepository;

import snow.pass.model.WeatherRecord;

public interface WeatherRecordRepository extends CrudRepository<WeatherRecord, String> {
}