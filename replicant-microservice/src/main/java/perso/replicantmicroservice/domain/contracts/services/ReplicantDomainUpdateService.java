package perso.replicantmicroservice.domain.contracts.services;

import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantAgeRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantNameRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantStatusRequestDTO;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public interface ReplicantDomainUpdateService {
	// == UPDATE ==
	Replicant update(Replicant replicant);

	Replicant updateName(String identifier, UpdateReplicantNameRequestDTO replicantRequest);

	Replicant updateAge(String identifier, UpdateReplicantAgeRequestDTO replicantRequest);

	Replicant updateStatus(String identifier, UpdateReplicantStatusRequestDTO updateReplicantStatusRequestDTO);
}
