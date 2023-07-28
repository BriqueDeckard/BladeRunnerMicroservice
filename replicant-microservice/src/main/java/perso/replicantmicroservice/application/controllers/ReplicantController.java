package perso.replicantmicroservice.application.controllers;

import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantAgeRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantNameRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantStatusRequestDTO;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainCreateService;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainDeleteService;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainReadService;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainUpdateService;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.clients.ApiCallService;


@RestController()
@RequestMapping("/api/v1/replicants")
public class ReplicantController {
	private final ReplicantDomainCreateService replicantDomainCreateService;
	private final ReplicantDomainDeleteService replicantDomainDeleteService;
	private final ReplicantDomainReadService replicantDomainReadService;
	private final ReplicantDomainUpdateService replicantDomainUpdateService;
	private final ApiCallService apiCallService;

	@Autowired
	public ReplicantController(ReplicantDomainCreateService replicantDomainCreateService, ReplicantDomainDeleteService replicantDomainDeleteService, ReplicantDomainReadService replicantDomainReadService, ReplicantDomainUpdateService replicantDomainUpdateService, ApiCallService apiCallService) {
		this.replicantDomainCreateService = replicantDomainCreateService;
		this.replicantDomainDeleteService = replicantDomainDeleteService;
		this.replicantDomainReadService = replicantDomainReadService;
		this.replicantDomainUpdateService = replicantDomainUpdateService;
		this.apiCallService = apiCallService;
	}


	@GetMapping("/info")
	String info() {
		return String.join(",\n", List.of(
				"GET/info",
				"POST",
				"GET",
				"GET/{identifier}",
				"PATCH/{identifier}",
				"PATCH/{identifier}/age",
				"DELETE/{identifier}",
				"DELETE"));
	}

	// == CREATE ==
	@PostMapping()
	Replicant create(@Valid @RequestBody CreateReplicantRequestDTO replicantRequest) {
		return replicantDomainCreateService.create(replicantRequest);
	}

	// == READ ==
	@GetMapping()
	Set<Replicant> all() {
		return replicantDomainReadService.findAll();
	}

	@GetMapping("/{identifier}")
	Replicant getByIdentifier(@PathVariable("identifier") String identifier) {
		return replicantDomainReadService.findByIdentifier(identifier);
	}

	// == UPDATE ==
	@PatchMapping("/{identifier}/name")
	Replicant patchName(@PathVariable("identifier") String identifier, @RequestBody UpdateReplicantNameRequestDTO updateReplicantNameRequestDTO) {
		return replicantDomainUpdateService.updateName(identifier, updateReplicantNameRequestDTO);
	}

	@PatchMapping("/{identifier}/age")
	Replicant patchAge(@PathVariable("identifier") String identifier,
	                   @RequestBody UpdateReplicantAgeRequestDTO updateReplicantAgeRequestDTO) {
		return replicantDomainUpdateService.updateAge(identifier, updateReplicantAgeRequestDTO);
	}

	@PatchMapping("/{identifier}/status")
	Replicant patchStatus(@PathVariable("identifier") String identifier,
	                      @RequestBody UpdateReplicantStatusRequestDTO updateReplicantStatusRequestDTO) {
		return replicantDomainUpdateService.updateStatus(identifier, updateReplicantStatusRequestDTO);
	}

	// == DELETE ==
	@DeleteMapping("/{identifier}")
	void deleteByIdentifier(@PathVariable("identifier") String identifier) {
		replicantDomainDeleteService.deleteByIdentifier(identifier);
	}

	@DeleteMapping()
	void deleteAll() {
		replicantDomainDeleteService.deleteAll();
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	public void handleIllegalArgumentException() {
	}
}
