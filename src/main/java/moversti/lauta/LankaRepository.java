package moversti.lauta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LankaRepository extends CrudRepository<Lanka, Long> {
	
}
