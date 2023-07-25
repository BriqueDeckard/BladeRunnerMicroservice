package perso.replicantmicroservice.application.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class CreateReplicantRequestDTO {
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
	public CreateReplicantRequestDTO(String name) {
		this.name = name;
	}

	@JsonCreator
	public CreateReplicantRequestDTO() {
	}

	@Override
	public String toString() {
		return "CreateReplicantRequestDTO{" +
				"name='" + name + '\'' +
				'}';
	}
}
