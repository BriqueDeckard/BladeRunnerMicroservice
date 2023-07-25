package perso.petmicroservice.petmicroservice.domain.contracts.model;

import perso.petmicroservice.petmicroservice.domain.enums.PetStatus;

public interface PetContract<ID> {

	ID getIdentifier();

	String getName();

	Integer getAge();

	PetStatus getStatus();
}
