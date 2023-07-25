package perso.petmicroservice.petmicroservice.domain.model;

import java.util.UUID;
import perso.petmicroservice.petmicroservice.domain.contracts.model.PetContract;
import perso.petmicroservice.petmicroservice.domain.enums.PetStatus;

public class Pet implements PetContract<UUID> {
	private UUID identifier;
	private String name;
	private Integer age;
	private PetStatus status;

	@Override
	public UUID getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public PetStatus getStatus() {
		return status;
	}

	public Pet(UUID identifier, String name, Integer age, PetStatus status) {
		this.identifier = identifier;
		this.name = name;
		this.age = age;
		this.status = status;
	}
}
