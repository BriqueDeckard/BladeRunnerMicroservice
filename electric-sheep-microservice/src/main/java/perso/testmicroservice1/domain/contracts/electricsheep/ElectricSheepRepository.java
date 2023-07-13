package perso.testmicroservice1.domain.contracts.electricsheep;

import java.util.UUID;
import perso.testmicroservice1.domain.model.ElectricSheep;

public interface ElectricSheepRepository {

	ElectricSheep findById(UUID id);

	void save(ElectricSheep order);

	void delete(UUID id);
}
