package perso.testmicroservice1.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantContract;
import perso.testmicroservice1.domain.enums.ReplicantStatus;

/**
 * This is the "aggregate root". Everything related to business logic for orders passes through here.
 * In addition, the Replicant class is supposed to maintain ITSELF in a correct state:
 * <ul>
 *     <li>The constructor ensures that a Replicant can only be built with the given id and an electric sheep. Status is initiated by the constructor.</li>
 *
 * </ul>
 */
public class Replicant implements ReplicantContract {
	private final UUID id;
	private ReplicantStatus status;
	private List<ReplicantPet> replicantPets;
	private BigDecimal price;

	public Replicant(UUID id, ElectricSheep electricSheep) {
		this.id = id;
		this.replicantPets = new ArrayList<>(List.of(new ReplicantPet(electricSheep)));
		this.status = ReplicantStatus.CREATED;
		this.price = electricSheep.getPrice();
	}

	public void complete() {
		validateState();
		this.status = ReplicantStatus.FREE;
	}

	public void addOrder(ElectricSheep electricSheep) {
		validateState();
		validateProduct(electricSheep);
		replicantPets.add(new ReplicantPet(electricSheep));
		price = price.add(electricSheep.getPrice());
	}

	public void removeReplicant(UUID id) {
		validateState();
		final ReplicantPet replicantPet = getOrderItem(id);
		replicantPets.remove(replicantPet);

		price = price.subtract(replicantPet.getPrice());
	}

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public ReplicantStatus getStatus() {
		return status;
	}

	@Override
	public List<ReplicantPet> getOrderItems() {
		return replicantPets;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "OrderImpl{" +
				"id=" + id +
				", status=" + status +
				", orderItems=" + replicantPets +
				", price=" + price +
				'}';
	}

	private void validateState() {
		if (status.equals(ReplicantStatus.FREE)) {
			throw new IllegalStateException("The order is completed.");
		}
	}

	private void validateProduct(ElectricSheep electricSheep) {
	}

	private ReplicantPet getOrderItem(UUID id) {
		Optional<ReplicantPet> orderItem = replicantPets
				.stream()
				.filter(replicantPet1 -> replicantPet1.getPetId().equals(id))
				.findAny();

		if (!orderItem.isPresent()) {
			throw new IllegalStateException("Cannot find orderItem with id : " + id);
		}
		return orderItem.get();
	}

	public void setReplicantPets(ArrayList<ReplicantPet> replicantPets) {
		this.replicantPets = replicantPets;
	}
}
