package perso.replicantmicroservice.application.contracts;

import java.util.UUID;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.model.Replicant;

public interface ReplicantApplicationService {
	UUID getAndCheckUuid(String id);

	Replicant mapReplicantRequest(CreateReplicantRequestDTO replicantRequest);
}
