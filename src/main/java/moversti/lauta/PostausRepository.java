package moversti.lauta;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostausRepository extends CrudRepository<Postaus, Long> {
	List<Postaus> findByLankaID(Long lankaID);
}
