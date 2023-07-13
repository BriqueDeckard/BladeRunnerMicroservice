package perso.testmicroservice1.application.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import perso.testmicroservice1.application.dto.requests.replicants.AddElectricSheepToReplicantRequestDTO;
import perso.testmicroservice1.application.dto.requests.replicants.CreateReplicantRequestDTO;
import perso.testmicroservice1.application.dto.response.replicants.CreateReplicantResponseDTO;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantService;
import perso.testmicroservice1.domain.model.ElectricSheep;
import perso.testmicroservice1.domain.model.Replicant;

/**
 * Restfull controller dedicated to {@link perso.testmicroservice1.domain.model.Replicant}
 * resource management.
 *
 * @author Deqard
 * @since 1.0
 */
@RestController
@RequestMapping("/orders")
@Tag(name = "order-controller")
public class ReplicantController {
	private final ReplicantService replicantService;

	/**
	 * Creates an instance of {@link ReplicantController} class.
	 *
	 * @param replicantService The {@link ReplicantService} which manage {@link Replicant}
	 */
	@Autowired
	public ReplicantController(ReplicantService replicantService) {

		this.replicantService = replicantService;
	}

	/**
	 * Endpoint to request the creation of a {@link Replicant}.
	 *
	 * @param request the {@link CreateReplicantRequestDTO}, which contains information about the creation of a {@link Replicant}.
	 */
	@Operation(
			summary = "Create an order",
			description = "Create an order",
			responses = {
					@ApiResponse(responseCode = "201", description = "Successfully created.",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(
											implementation = CreateReplicantResponseDTO.class
									)
							)
					),
					@ApiResponse(responseCode = "400", description = "Client error."),
					@ApiResponse(responseCode = "500", description = "Server error.")
			}
	)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CreateReplicantResponseDTO> createReplicant(
			@RequestBody CreateReplicantRequestDTO request
	) {
		UUID id = replicantService.createReplicant(request.getSheep());
		return ResponseEntity.ok(new CreateReplicantResponseDTO(id));
	}

	/**
	 * Endpoint to request the addition of a {@link ElectricSheep} to a {@link Replicant}.
	 *
	 * @param id      Product id.
	 * @param request le {@link AddElectricSheepToReplicantRequestDTO} that contains the product information.
	 */
	@Operation(
			summary = "Add a product to an order",
			description = "Add a product to an order",
			responses = {
					@ApiResponse(responseCode = "200", description = "OK.",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(
											implementation = CreateReplicantResponseDTO.class
									)
							)
					),
					@ApiResponse(responseCode = "400", description = "Client error."),
					@ApiResponse(responseCode = "500", description = "Server error.")
			}
	)
	@PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
	void addProduct(@PathVariable UUID id, @RequestBody AddElectricSheepToReplicantRequestDTO request) {
		replicantService.addElectricSheep(id, request.getElectricSheep());
	}

	/**
	 * Endpoint to request the deletion of a {@link ElectricSheep} from an {@link Replicant}
	 *
	 * @param id        identifier of the order
	 * @param productId identifier of the product to remove
	 */
	@Operation(
			summary = "Delete a product from an order.",
			description = "Delete a product from an order.",
			responses = {
					@ApiResponse(responseCode = "200", description = "OK.",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(
											implementation = CreateReplicantResponseDTO.class
									)
							)
					),
					@ApiResponse(responseCode = "400", description = "Client error."),
					@ApiResponse(responseCode = "500", description = "Server error.")
			}
	)
	@DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
	void deleteProduct(@PathVariable UUID id, @RequestParam UUID productId) {
		replicantService.deleteElectricSheep(id, productId);
	}

	/**
	 * Endpoint to request the release of an {@link Replicant}
	 *
	 * @param id The identifier of the Replicant to release.
	 */
	@Operation(
			summary = "Complete an order.",
			description = "Complete an order.",
			responses = {
					@ApiResponse(responseCode = "200", description = "OK.",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(
											implementation = CreateReplicantResponseDTO.class
									)
							)
					),
					@ApiResponse(responseCode = "400", description = "Client error."),
					@ApiResponse(responseCode = "500", description = "Server error.")
			}
	)
	@PostMapping("/{id}/complete")
	void completeOrder(@PathVariable UUID id) {
		replicantService.freeReplicant(id);
	}

	/**
	 * Handle {@link RuntimeException}
	 *
	 * @param ex      the involved {@link RuntimeException}
	 * @param request the involved {@link WebRequest}
	 * @return a {@link ResponseEntity} with the {@code HTTP500} code.
	 */
	@ExceptionHandler(value
			= { RuntimeException.class })
	protected ResponseEntity<Object> handleRuntimeException(
			RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Something went wrong, bruh : " + ex.getMessage();
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
