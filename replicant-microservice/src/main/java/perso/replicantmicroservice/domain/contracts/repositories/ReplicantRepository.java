package perso.replicantmicroservice.domain.contracts.repositories;

import java.util.Collection;
import java.util.UUID;
import perso.replicantmicroservice.domain.model.Replicant;

public interface ReplicantRepository {
	Replicant create(Replicant entity);

	Collection<Replicant> read();

	Replicant read(UUID identifier);

	Replicant update(Replicant entity, UUID identifier);

	void delete(UUID identifier);

	void delete();
}
