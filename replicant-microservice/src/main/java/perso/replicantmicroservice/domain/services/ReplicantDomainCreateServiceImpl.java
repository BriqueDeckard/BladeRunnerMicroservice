package perso.replicantmicroservice.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainCreateService;
import perso.replicantmicroservice.domain.model.Replicant;

/**
 * This class is a Spring service that handles the creation of Replicant objects.
 * It implements the ReplicantDomainCreateService interface.
 */
@Service
public class ReplicantDomainCreateServiceImpl implements ReplicantDomainCreateService {
	private final ReplicantRepository replicantRepository;
	private final ReplicantApplicationService replicantApplicationService;

	/**
	 * Constructor for creating a ReplicantDomainCreateServiceImpl instance.
	 *
	 * @param replicantRepository         The repository for Replicant objects.
	 * @param replicantApplicationService The service for mapping Replicant request DTOs to Replicant entities.
	 */
	@Autowired
	public ReplicantDomainCreateServiceImpl(
			ReplicantRepository replicantRepository,
			ReplicantApplicationService replicantApplicationService) {
		this.replicantRepository = replicantRepository;
		this.replicantApplicationService = replicantApplicationService;
	}

	/**
	 * Creates a new Replicant based on the provided DTO and updates it in the repository.
	 *
	 * @param replicantRequest The DTO containing the data for creating a Replicant.
	 * @return The created or updated Replicant object.
	 */
	@Override
	public Replicant create(CreateReplicantRequestDTO replicantRequest) {
		Replicant replicant = replicantApplicationService.mapReplicantRequest(replicantRequest);
		replicant = replicantRepository.update(replicant, replicant.getIdentifier());
		return replicant;
	}
}
