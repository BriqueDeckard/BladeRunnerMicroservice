package perso.testmicroservice1.application.controllers;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perso.testmicroservice1.application.dto.requests.electricsheep.CreateElectricSheepRequestDTO;
import perso.testmicroservice1.application.dto.response.electricsheep.CreateElectricSheepResponseDTO;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepService;
import perso.testmicroservice1.domain.model.ElectricSheep;

/**
 * Restfull controller dedicated to {@link ElectricSheep} resource management.
 *
 * @author Deqard
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/products")
@Api(value = "product-controller")
public class ElectricSheepController {
	private final ElectricSheepService electricSheepService;

	/**
	 * Create a new instance of {@link ElectricSheepController}.
	 *
	 * @param electricSheepService The service that manage the {@link ElectricSheep}.
	 */
	@Autowired
	public ElectricSheepController(ElectricSheepService electricSheepService) {
		this.electricSheepService = electricSheepService;
	}

	/**
	 * Endpoint to create a {@link ElectricSheep}.
	 *
	 * @param requestBody {@link CreateElectricSheepRequestDTO} containing information about the product to create.
	 * @return {@link CreateElectricSheepResponseDTO} containing information about the created product.
	 */
	@Operation(
			summary = "Create a product",
			description = "Create a Product",
			responses = {
					@ApiResponse(responseCode = "201", description = "Successfully created.",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(
											implementation = CreateElectricSheepResponseDTO.class
									)
							)
					),
					@ApiResponse(responseCode = "400", description = "Client error."),
					@ApiResponse(responseCode = "500", description = "Server error."),

			}
	)
	@PostMapping()
	ResponseEntity<CreateElectricSheepResponseDTO> createProduct(
			@RequestBody(
					description = "Product information.",
					required = true,
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(
									implementation = CreateElectricSheepRequestDTO.class
							)
					)
			)
			CreateElectricSheepRequestDTO requestBody
	) {
		return ResponseEntity.ok(
				electricSheepService.createElectricSheep(requestBody)
		);
	}
}
