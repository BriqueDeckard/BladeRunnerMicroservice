package perso.testmicroservice1.domain.contracts.replicants;

import java.util.Optional;
import java.util.UUID;
import perso.testmicroservice1.domain.model.Replicant;

public interface ReplicantRepository {

	Optional<Replicant> findById(UUID id);

	void save(Replicant order);
}
