package perso.testmicroservice1.application.dto.requests.replicants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import perso.testmicroservice1.application.dto.base.ElectricSheepDTO;
import perso.testmicroservice1.application.dto.requests.electricsheep.ElectricSheepRequestDTO;
import perso.testmicroservice1.domain.model.ElectricSheep;

/**
 * Contains information to create an {@link perso.testmicroservice1.domain.model.Replicant}
 *
 * @author Deqard
 * @since 1.0
 */
@ApiModel(
		value = "CreateOrderRequestDTO",
		description = "Contains information to create an Order."
)
public class CreateReplicantRequestDTO {
	@NotNull(message = "ElectricSheep cannot be null")
	private final ElectricSheepRequestDTO electricSheep;

	/**
	 * Creates an instance of {@link CreateReplicantRequestDTO}
	 *
	 * @param electricSheep the involved {@link ElectricSheep}
	 */
	@JsonCreator
	public CreateReplicantRequestDTO(@JsonProperty("electricSheep") ElectricSheepRequestDTO electricSheep) {
		this.electricSheep = electricSheep;
	}

	public ElectricSheepRequestDTO getSheep() {
		return electricSheep;
	}

	@Override
	public String toString() {
		return "CreateOrderRequestDTO{" +
				"product=" + electricSheep +
				'}';
	}
}
