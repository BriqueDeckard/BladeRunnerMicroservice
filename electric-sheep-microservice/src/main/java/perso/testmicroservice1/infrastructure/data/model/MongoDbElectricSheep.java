package perso.testmicroservice1.infrastructure.data.model;

import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepContract;

public class MongoDbElectricSheep implements ElectricSheepContract {

	@NotNull(message = "Id must not be null.")
	private final UUID id;
	@NotNull(message = "Price must not be null.")
	private final BigDecimal price;
	@NotEmpty(message = "Name must not be null or blank.")
	private final String name;

	public MongoDbElectricSheep(UUID id, BigDecimal price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
