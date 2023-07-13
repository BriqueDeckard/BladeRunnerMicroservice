package perso.testmicroservice1.application.dto.response.electricsheep;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;

public class CreateElectricSheepResponseDTO {
	UUID id;

	@JsonCreator
	public CreateElectricSheepResponseDTO(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
