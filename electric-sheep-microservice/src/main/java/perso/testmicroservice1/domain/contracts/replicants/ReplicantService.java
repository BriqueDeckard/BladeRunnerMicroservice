package perso.testmicroservice1.domain.contracts.replicants;

import java.util.UUID;
import perso.testmicroservice1.application.dto.base.ElectricSheepDTO;
import perso.testmicroservice1.application.dto.requests.electricsheep.ElectricSheepRequestDTO;

public interface ReplicantService {

	UUID createReplicant(ElectricSheepRequestDTO product);

	void addElectricSheep(UUID id, ElectricSheepDTO product);

	void freeReplicant(UUID id);

	void deleteElectricSheep(UUID id, UUID electricSheepId);
}
