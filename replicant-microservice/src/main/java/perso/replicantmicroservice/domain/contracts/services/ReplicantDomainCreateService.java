package perso.replicantmicroservice.domain.contracts.services;

import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public interface ReplicantDomainCreateService {
	// == CREATE ==
	Replicant create(CreateReplicantRequestDTO replicantRequest);
}
