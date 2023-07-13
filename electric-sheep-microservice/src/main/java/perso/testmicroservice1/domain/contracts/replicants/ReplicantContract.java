package perso.testmicroservice1.domain.contracts.replicants;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import perso.testmicroservice1.domain.enums.ReplicantStatus;
import perso.testmicroservice1.domain.model.ReplicantPet;

public interface ReplicantContract {
	UUID getId();

	ReplicantStatus getStatus();

	List<ReplicantPet> getOrderItems();

	BigDecimal getPrice();

	@Override
	String toString();

}
