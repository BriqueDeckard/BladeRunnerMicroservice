package perso.testmicroservice1.infrastructure.data.repositories.orders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import perso.testmicroservice1.domain.model.Replicant;
import perso.testmicroservice1.domain.model.ElectricSheep;

@Repository
public class SpringDataMongoReplicantRepository {

	private static final ArrayList<Replicant> orders;

	static {
		ElectricSheep electricSheep1 = new ElectricSheep(UUID.randomUUID(), BigDecimal.TEN, "ProductA");
		ElectricSheep electricSheep2 = new ElectricSheep(UUID.randomUUID(), BigDecimal.ONE, "ProductB");
		orders = new ArrayList<>(List.of(
				new Replicant(UUID.fromString("702e1867-0953-49d4-891c-851caf935577"), electricSheep1),
				new Replicant(UUID.randomUUID(), electricSheep2)
		));
	}


	public Optional<Replicant> findById(UUID id) {
		return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
	}


	public void save(Replicant order) {
		orders.add(order);
	}
}
