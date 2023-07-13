package perso.testmicroservice1.infrastructure.data.repositories.orders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import perso.testmicroservice1.domain.model.Replicant;
import perso.testmicroservice1.domain.model.ElectricSheep;

public class CassandraDbOrderRepository {
	private static final ArrayList<Replicant> orders;

	static {
		ElectricSheep electricSheep1 = new ElectricSheep(UUID.randomUUID(), BigDecimal.TEN, "ProductA");
		ElectricSheep electricSheep2 = new ElectricSheep(UUID.randomUUID(), BigDecimal.ONE, "ProductB");
		orders = new ArrayList<>(List.of(
				new Replicant(UUID.randomUUID(), electricSheep1),
				new Replicant  (UUID.randomUUID(), electricSheep2)
		));
	}

	public Optional<Replicant> findById(UUID id) {
		return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
	}

	public void save(Replicant order) {
		orders.add(order);
	}
}
