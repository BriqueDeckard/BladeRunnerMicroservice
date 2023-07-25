package perso.petmicroservice.petmicroservice.infrastructure.data.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import perso.petmicroservice.petmicroservice.infrastructure.data.model.MongoPet;

public interface MongoPetRepository extends MongoRepository<MongoPet, String> {
	Optional<MongoPet> findByIdentifierLike(String string);

	void deleteByIdentifierLike(String identifier);
}
