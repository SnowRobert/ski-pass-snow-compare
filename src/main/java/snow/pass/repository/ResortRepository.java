package snow.pass.repository;

import org.springframework.data.repository.CrudRepository;

import snow.pass.model.Resort;

public interface ResortRepository extends CrudRepository<Resort, String> {
    
}
