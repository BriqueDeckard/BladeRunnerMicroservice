package perso.replicantmicroservice.domain.services;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantAgeRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantNameRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantStatusRequestDTO;
import perso.replicantmicroservice.domain.contracts.mappers.to.entity.CreateReplicantRequestDTOToReplicantMapper;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainCreateService;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public class ReplicantDomainCreateServiceImpl implements ReplicantDomainCreateService {

	private final ReplicantRepository replicantRepository;

	private final  CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper;

	private final  ReplicantApplicationService replicantApplicationService;

	@Autowired
	public ReplicantDomainCreateServiceImpl(
			ReplicantRepository replicantRepository,
			CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper,
			ReplicantApplicationService replicantApplicationService) {
		this.replicantRepository = replicantRepository;
		this.createReplicantRequestDTOToReplicantMapper = createReplicantRequestDTOToReplicantMapper;
		this.replicantApplicationService = replicantApplicationService;
	}

	@Override
	public Replicant create(CreateReplicantRequestDTO replicantRequest) {
		Replicant replicant = createReplicantRequestDTOToReplicantMapper.toReplicant(replicantRequest);
		replicant = replicantRepository.update(replicant, replicant.getIdentifier());
		return replicant;
	}
}
