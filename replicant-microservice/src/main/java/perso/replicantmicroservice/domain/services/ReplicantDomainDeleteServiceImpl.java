package perso.replicantmicroservice.domain.services;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainDeleteService;

@Service
public class ReplicantDomainDeleteServiceImpl implements ReplicantDomainDeleteService {
	private final ReplicantRepository replicantRepository;

	private final ReplicantApplicationService replicantApplicationService;

	@Autowired
	public ReplicantDomainDeleteServiceImpl(ReplicantRepository replicantRepository, ReplicantApplicationService replicantApplicationService) {
		this.replicantRepository = replicantRepository;
		this.replicantApplicationService = replicantApplicationService;
	}

	@Override
	public void deleteAll() {
		replicantRepository.delete();
	}

	@Override
	public void deleteByIdentifier(String identifier) {
		UUID id = replicantApplicationService.getAndCheckUuid(identifier);
		replicantRepository.delete(id);
	}
}
