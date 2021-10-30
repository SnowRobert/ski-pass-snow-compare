package snow.pass.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import snow.pass.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
