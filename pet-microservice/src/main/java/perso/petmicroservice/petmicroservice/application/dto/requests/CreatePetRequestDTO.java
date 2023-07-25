package perso.petmicroservice.petmicroservice.application.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class CreatePetRequestDTO {
	@NotBlank
	@JsonProperty("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreatePetRequestDTO(String name) {
		this.name = name;
	}

	public CreatePetRequestDTO() {
	}

	@Override
	public String toString() {
		return "CreatePetRequestDTO{" +
				"name='" + name + '\'' +
				'}';
	}
}
