package perso.testmicroservice1.application.dto.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import perso.testmicroservice1.domain.model.ElectricSheep;

/**
 * Base DTO for {@link ElectricSheep} object.
 *
 * @author Deqard
 * @since 1.0
 */
@ApiModel(
		value = "Product DTO",
		description = "Contains product information."
)
public class ElectricSheepDTO {

	/**
	 * Identifier of the {@link ElectricSheep}.
	 */
	@JsonProperty("id")
	@Schema(name = "Product ID", example = "11", required = true)
	@ApiModelProperty(value = "Product identifier", name = "Id", example = "8f74e14c-3c72-4711-862f-43cb6ab0567b")
	@NotNull(message = "Id cannot be null.")
	UUID id;

	/**
	 * Price of the {@link ElectricSheep}.
	 */
	@JsonProperty("price")
	@Schema(name = "Product price", example = "11.00", required = true)
	@ApiModelProperty(value = "Product price", name = "price", example = "11.0")
	@NotNull(message = "Price cannot be null.")
	BigDecimal price;

	/**
	 * Name of the {@link ElectricSheep}.
	 */
	@JsonProperty("name")
	@Schema(name = "Product name", example = "Name", required = true)
	@ApiModelProperty(value = "Product name", name = "name", example = "Name")
	@NotNull(message = "Name cannot be null.")
	@NotBlank(message = "Name cannot be blank.")
	String name;

	/**
	 * Creates an instance of a {@link ElectricSheepDTO}
	 *
	 * @param id    identifier of the {@link ElectricSheep}
	 * @param price price of the {@link ElectricSheep}
	 * @param name  name of the {@link ElectricSheep}
	 */
	@JsonCreator
	public ElectricSheepDTO(UUID id, BigDecimal price, String name) {
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

	public void setId(UUID id) {
		this.id = id;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductRequestDTO{" +
				"id=" + id +
				", price=" + price +
				", name='" + name + '\'' +
				'}';
	}
}
