package perso.replicantmicroservice.infrastructure.data.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import perso.replicantmicroservice.infrastructure.data.model.MongoReplicant;

public interface MongoReplicantRepository extends MongoRepository<MongoReplicant, String> {
	Optional<MongoReplicant> findByIdentifierLike(String identifier);

	void deleteByIdentifierLike(String identifier);
}
