package perso.replicantmicroservice.application.contracts;

import java.util.UUID;

public interface ReplicantApplicationService {
	UUID getAndCheckUuid(String id);
}
