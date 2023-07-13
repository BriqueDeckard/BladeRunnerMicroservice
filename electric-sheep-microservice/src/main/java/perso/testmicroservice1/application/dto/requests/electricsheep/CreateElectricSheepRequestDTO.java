package perso.testmicroservice1.application.dto.requests.electricsheep;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import java.util.UUID;
import perso.testmicroservice1.domain.model.ElectricSheep;

/**
 * Contains information to create a {@link ElectricSheep}
 *
 * @author Deqard
 * @since 1.0
 */
@ApiModel(
		value = "Create Product DTO",
		description = "Contains product information."
)
public class CreateElectricSheepRequestDTO extends ElectricSheepRequestDTO {
	/**
	 * Create an instance of {@link CreateElectricSheepRequestDTO}
	 *
	 * @param id    the identifier of the product
	 * @param price the price of the product
	 * @param name  the name of the product
	 */
	@JsonCreator
	public CreateElectricSheepRequestDTO(
			UUID id,
			BigDecimal price,
			String name) {
		super(id, price, name);
	}
}
