package perso.testmicroservice1.domain.model;

import java.math.BigDecimal;
import java.util.UUID;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepContract;

public class ElectricSheep implements ElectricSheepContract {
	private final UUID id;
	private final BigDecimal price;
	private final String name;

	public ElectricSheep(UUID id, BigDecimal price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public UUID getId() {
		return id;
	}
}