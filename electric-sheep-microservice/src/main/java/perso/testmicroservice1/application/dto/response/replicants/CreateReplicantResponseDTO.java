package perso.testmicroservice1.application.dto.response.replicants;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;

public class CreateReplicantResponseDTO {
	UUID id;

	@JsonCreator
	public CreateReplicantResponseDTO(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
