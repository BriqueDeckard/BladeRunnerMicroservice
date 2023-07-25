package perso.replicantmicroservice.domain.contracts.repositories;

import java.util.UUID;
import perso.library.domain.contracts.repositories.GenericDomainRepository;
import perso.replicantmicroservice.domain.model.Replicant;

public interface ReplicantRepository extends GenericDomainRepository<Replicant, UUID> {
	Replicant update(Replicant replicant);
}
