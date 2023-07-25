package perso.replicantmicroservice.domain.services;

import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.application.dto.requests.UpdateReplicantRequestDTO;
import perso.replicantmicroservice.domain.contracts.mappers.to.entity.CreateReplicantRequestDTOToReplicantMapper;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainService;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public class ReplicantDomainServiceImpl implements ReplicantDomainService {

	ReplicantRepository replicantRepository;

	CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper;

	@Autowired
	public ReplicantDomainServiceImpl(ReplicantRepository replicantRepository, CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper) {
		this.replicantRepository = replicantRepository;
		this.createReplicantRequestDTOToReplicantMapper = createReplicantRequestDTOToReplicantMapper;
	}

	@Override
	public Replicant save(Replicant replicant) {
		return replicantRepository.save(replicant);
	}

	@Override
	public void deleteAll() {
		replicantRepository.deleteAll();
	}

	@Override
	public void deleteByIdentifier(String identifier) {
		replicantRepository.deleteByIdentifier(identifier);
	}

	@Override
	public Set<Replicant> findAll() {
		return replicantRepository.findAll();
	}

	@Override
	public Replicant create(CreateReplicantRequestDTO replicantRequest) {
		Replicant replicant = createReplicantRequestDTOToReplicantMapper.toReplicant(replicantRequest);
		replicant = save(replicant);
		return replicant;
	}

	@Override
	public Replicant findByIdentifier(String identifier) {
		UUID id;
		try {
			id = UUID.fromString(identifier);
		}catch (Exception e){
			throw e;
		}

		return replicantRepository.findByIdentifier(id);
	}

	@Override
	public Replicant updateByIdentifier(String identifier, UpdateReplicantRequestDTO replicantRequest) {
		Replicant replicant = findByIdentifier(identifier);
		replicant.setName(replicantRequest.getName());
		replicantRepository.update(replicant);
		return null;
	}


}
