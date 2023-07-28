package perso.replicantmicroservice.domain.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantAgeRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantNameRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantStatusRequestDTO;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainUpdateService;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public class ReplicantDomainUpdateServiceImpl implements ReplicantDomainUpdateService {
	private final ReplicantRepository replicantRepository;

	private final ReplicantApplicationService replicantApplicationService;

	public ReplicantDomainUpdateServiceImpl(ReplicantRepository replicantRepository, ReplicantApplicationService replicantApplicationService) {
		this.replicantRepository = replicantRepository;
		this.replicantApplicationService = replicantApplicationService;
	}

	@Override
	public Replicant update(Replicant replicant) {
		return replicantRepository.create(replicant);
	}


	@Override
	public Replicant updateName(String identifier, UpdateReplicantNameRequestDTO replicantRequest) {
		UUID id = replicantApplicationService.getAndCheckUuid(identifier);
		Replicant replicant = replicantRepository.read(id);
		replicant.setName(replicantRequest.getName());
		replicantRepository.update(replicant, id);
		return replicant;
	}

	@Override
	public Replicant updateAge(String identifier, UpdateReplicantAgeRequestDTO replicantRequest) {
		UUID id = replicantApplicationService.getAndCheckUuid(identifier);
		Replicant replicant =  replicantRepository.read(id);
		replicant.setAge(replicantRequest.getAge());
		replicantRepository.update(replicant, id);
		return replicant;
	}

	@Override
	public Replicant updateStatus(String identifier, UpdateReplicantStatusRequestDTO updateReplicantStatusRequestDTO) {
		UUID id = replicantApplicationService.getAndCheckUuid(identifier);
		Replicant replicant =  replicantRepository.read(id);
		replicant.setStatus(updateReplicantStatusRequestDTO.getStatus());
		replicantRepository.update(replicant, id);
		return replicant;
	}
}
