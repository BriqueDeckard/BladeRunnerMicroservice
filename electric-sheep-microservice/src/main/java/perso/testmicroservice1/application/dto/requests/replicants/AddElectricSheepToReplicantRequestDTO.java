package perso.testmicroservice1.application.dto.requests.replicants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import perso.testmicroservice1.application.dto.base.ElectricSheepDTO;
import perso.testmicroservice1.domain.model.Replicant;
import perso.testmicroservice1.domain.model.ElectricSheep;

/**
 * Request to add a {@link ElectricSheep} to an {@link Replicant}
 *
 * @author Deqard
 * @since 1.0
 */
@ApiModel(
		value = "AddProductToOrderRequestDTO",
		description = "Contains information to add a Product to an Order."
)
public class AddElectricSheepToReplicantRequestDTO {

	/**
	 * Product to add to the order.
	 */
	@JsonProperty("product")
	@Schema(name = "Product ID", required = true)
	@ApiModelProperty(value = "Product information", name = "Product", required = true)
	@Valid
	@NotNull(message = "Product cannot be null.")
	ElectricSheepDTO electricSheep;

	/**
	 * Create a new instance of {@link AddElectricSheepToReplicantRequestDTO}
	 *
	 * @param electricSheep the {@link ElectricSheep}
	 */
	@JsonCreator
	public AddElectricSheepToReplicantRequestDTO(@JsonProperty("product") final ElectricSheepDTO electricSheep) {
		this.electricSheep = electricSheep;
	}

	public ElectricSheepDTO getElectricSheep() {
		return electricSheep;
	}
}
