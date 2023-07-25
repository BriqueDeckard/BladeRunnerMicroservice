package perso.replicantmicroservice.application.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class UpdateReplicantRequestDTO {

	@NotBlank
	@JsonProperty("name")
	private String name;

	@JsonCreator
	public UpdateReplicantRequestDTO(String name) {
		this.name = name;
	}

	@JsonCreator
	public UpdateReplicantRequestDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UpdateReplicantRequest{" +
				"name='" + name + '\'' +
				'}';
	}
}
