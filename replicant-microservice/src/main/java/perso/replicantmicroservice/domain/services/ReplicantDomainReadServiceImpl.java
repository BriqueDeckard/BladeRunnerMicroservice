package perso.replicantmicroservice.domain.services;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;
import perso.replicantmicroservice.domain.contracts.mappers.to.entity.CreateReplicantRequestDTOToReplicantMapper;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainReadService;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public class ReplicantDomainReadServiceImpl implements ReplicantDomainReadService {
	private final ReplicantRepository replicantRepository;

	private final CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper;

	private final ReplicantApplicationService replicantApplicationService;

	@Autowired
	public ReplicantDomainReadServiceImpl(ReplicantRepository replicantRepository, CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper, ReplicantApplicationService replicantApplicationService) {
		this.replicantRepository = replicantRepository;
		this.createReplicantRequestDTOToReplicantMapper = createReplicantRequestDTOToReplicantMapper;
		this.replicantApplicationService = replicantApplicationService;
	}

	@Override
	public Set<Replicant> findAll() {
		return new HashSet<>(replicantRepository.read());
	}

	@Override
	public Replicant findByIdentifier(String identifier) {
		UUID id = replicantApplicationService.getAndCheckUuid(identifier);
		Replicant replicant=  replicantRepository.read(id);
		return replicant;
	}
}
