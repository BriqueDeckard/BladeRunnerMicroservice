package perso.replicantmicroservice.application.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class UpdateReplicantNameRequestDTO {

	@NotBlank
	@JsonProperty("name")
	private String name;

	@JsonCreator
	public UpdateReplicantNameRequestDTO(String name) {
		this.name = name;
	}

	@JsonCreator
	public UpdateReplicantNameRequestDTO() {
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
