package perso.replicantmicroservice.application.controllers;

import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantRequestDTO;
import perso.replicantmicroservice.application.dto.response.PetDto;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainService;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.clients.ApiCallService;
import reactor.core.publisher.Mono;


@RestController()
@RequestMapping("/api/v1/replicants")
public class ReplicantController {

	@Autowired
	public ReplicantController(ReplicantDomainService replicantDomainService, ApiCallService apiCallService) {
		this.replicantDomainService = replicantDomainService;
		this.apiCallService = apiCallService;
	}

	private final ReplicantDomainService replicantDomainService;
	private final ApiCallService apiCallService;

	@PostMapping()
	Replicant create(@Valid @RequestBody CreateReplicantRequestDTO replicantRequest) {
		return replicantDomainService.create(replicantRequest);
	}

	@GetMapping()
	Set<Replicant> all() {
		return replicantDomainService.findAll();
	}

	@GetMapping("/{identifier}")
	Replicant getByIdentifier(@PathVariable("identifier") String identifier) {
		return replicantDomainService.findByIdentifier(identifier);
	}

	@PatchMapping("/{identifier}")
	Replicant patchByIdentifier(@PathVariable("identifier") String identifier, @RequestBody UpdateReplicantRequestDTO replicantRequest) {
		return replicantDomainService.updateByIdentifier(identifier, replicantRequest);
	}

	@DeleteMapping("/{identifier}")
	void deleteByIdentifier(@PathVariable("identifier") String identifier) {
		replicantDomainService.deleteByIdentifier(identifier);
	}

	@DeleteMapping()
	void deleteAll() {
		replicantDomainService.deleteAll();
	}

	@GetMapping("/apicall")
	Mono<Set<PetDto>> apiCall() {
		return apiCallService.someRestCall("/api/v1/pet").collect(Collectors.toSet());
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	public void handleIllegalArgumentException() {

	}
}
