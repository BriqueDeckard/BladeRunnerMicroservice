package perso.replicantmicroservice.domain.contracts.model;

import perso.replicantmicroservice.domain.enums.ReplicantStatus;

public interface ReplicantContract<ID> {
	ID getIdentifier();

	String getName();

	Integer getAge();

	ReplicantStatus getStatus();
}
