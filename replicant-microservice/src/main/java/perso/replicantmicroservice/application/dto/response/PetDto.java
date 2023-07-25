package perso.replicantmicroservice.application.dto.response;

import java.util.UUID;

public class PetDto {
	private UUID identifier;
	private String name;
	private Integer age;
	private String status;

	public UUID getIdentifier() {
		return identifier;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
	public String getStatus() {
		return status;
	}

	public PetDto(UUID identifier, String name, Integer age, String status) {
		this.identifier = identifier;
		this.name = name;
		this.age = age;
		this.status = status;
	}
}
