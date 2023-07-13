package perso.testmicroservice1.infrastructure.data.repositories.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import perso.testmicroservice1.infrastructure.data.model.MongoDbElectricSheep;

@Repository
public class SpringDataMongoProductRepository {
	private static final ArrayList<MongoDbElectricSheep> products;

	static {
		products = new ArrayList<>(List.of(
				new MongoDbElectricSheep(UUID.randomUUID(), BigDecimal.TEN, "ProductA"),
				new MongoDbElectricSheep(UUID.randomUUID(), BigDecimal.ONE, "ProductB")
		));
	}

	public Optional<MongoDbElectricSheep> findById(UUID id) {
		return products.stream().filter(product -> product.getId().equals(id)).findFirst();
	}

	public void save(MongoDbElectricSheep product) {
		products.add(product);
	}

	public void delete(UUID id) {
		products.remove(products.stream().filter(product1 -> product1.getId().equals(id)).findFirst().orElseThrow());
	}
}
