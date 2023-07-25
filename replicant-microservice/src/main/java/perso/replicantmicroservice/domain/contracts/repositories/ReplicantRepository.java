package perso.replicantmicroservice.domain.contracts.repositories;

import java.util.Set;
import perso.replicantmicroservice.domain.model.Replicant;

public interface ReplicantRepository {
	Replicant save(Replicant replicant);

	void deleteAll();

	Set<Replicant> findAll();

	Replicant findByIdentifier(String identifier);

	void deleteByIdentifier(String identifier);

	Replicant update(Replicant replicant);
}
