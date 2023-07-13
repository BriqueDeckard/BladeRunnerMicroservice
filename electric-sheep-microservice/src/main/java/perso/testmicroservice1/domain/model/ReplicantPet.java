package perso.testmicroservice1.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * ReplicantPet is created based on a Product. It keeps the reference to it and stores the current price of the Product.
 */
public class ReplicantPet {
	BigDecimal price;
	UUID petId;

	public ReplicantPet(ElectricSheep electricSheep) {
		this.petId = electricSheep.getId();
		this.price = electricSheep.getPrice();
	}

	public UUID getPetId() {
		return petId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "OrderItem{" +
				"price=" + price +
				", productId=" + petId +
				'}';
	}
}