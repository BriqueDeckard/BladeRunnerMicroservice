package perso.replicantmicroservice.domain.contracts.model;

import java.util.UUID;
import perso.replicantmicroservice.domain.enums.ReplicantStatus;

public interface ReplicantContract<ID> {
	ID getIdentifier();

	String getName();

	Integer getAge();

	ReplicantStatus getStatus();
}
