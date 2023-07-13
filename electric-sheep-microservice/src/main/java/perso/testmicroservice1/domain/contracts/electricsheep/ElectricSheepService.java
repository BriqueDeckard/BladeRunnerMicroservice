package perso.testmicroservice1.domain.contracts.electricsheep;

import java.util.UUID;
import perso.testmicroservice1.application.dto.requests.electricsheep.CreateElectricSheepRequestDTO;
import perso.testmicroservice1.application.dto.response.electricsheep.CreateElectricSheepResponseDTO;

public interface ElectricSheepService {

	CreateElectricSheepResponseDTO createElectricSheep(CreateElectricSheepRequestDTO product);

	void deleteElectricSheep(UUID productId);
}
