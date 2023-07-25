package perso.petmicroservice.petmicroservice.application.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class UpdatePetRequestDTO {
	@NotBlank
	@JsonProperty("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonCreator
	public UpdatePetRequestDTO(String name) {
		this.name = name;
	}

	@JsonCreator
	public UpdatePetRequestDTO() {
	}

	@Override
	public String toString() {
		return "UpdatePetRequestDTO{" +
				"name='" + name + '\'' +
				'}';
	}
}
