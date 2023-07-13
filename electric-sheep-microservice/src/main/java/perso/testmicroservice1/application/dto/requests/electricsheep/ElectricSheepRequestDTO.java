package perso.testmicroservice1.application.dto.requests.electricsheep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import java.util.UUID;
import perso.testmicroservice1.application.dto.base.ElectricSheepDTO;
import perso.testmicroservice1.domain.model.ElectricSheep;

/**
 * Contains information about a {@link ElectricSheep}
 */
@ApiModel(
		value = "Product DTO",
		description = "Contains product information."
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElectricSheepRequestDTO extends ElectricSheepDTO {
	/**
	 * Creates a new instance of {@link ElectricSheepRequestDTO}
	 *
	 * @param id    identifier of the {@link ElectricSheep}
	 * @param price price of the {@link ElectricSheep}
	 * @param name  name of the {@link ElectricSheep}
	 */
	@JsonCreator
	public ElectricSheepRequestDTO(UUID id, BigDecimal price, String name) {
		super(id, price, name);
	}
}
