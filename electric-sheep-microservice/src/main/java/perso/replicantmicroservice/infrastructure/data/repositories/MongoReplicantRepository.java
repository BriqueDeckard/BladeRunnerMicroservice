package perso.replicantmicroservice.infrastructure.data.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.model.MongoDbReplicant;

public interface MongoReplicantRepository extends MongoRepository<MongoDbReplicant, String> {
	Optional<MongoDbReplicant> findByIdentifierLike(String identifier);

	void deleteByIdentifierLike(String identifier);
}
