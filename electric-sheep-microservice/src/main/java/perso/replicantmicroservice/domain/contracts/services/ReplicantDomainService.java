package perso.replicantmicroservice.domain.contracts.services;

import java.util.Set;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantRequestDTO;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public interface ReplicantDomainService {
	Replicant save(Replicant replicant);

	void deleteAll();

	void deleteByIdentifier(String identifier);

	Set<Replicant> findAll();

	Replicant create(CreateReplicantRequestDTO replicantRequest);

	Replicant findByIdentifier(String identifier);

	Replicant updateByIdentifier(String identifier, UpdateReplicantRequestDTO replicantRequest);
}
