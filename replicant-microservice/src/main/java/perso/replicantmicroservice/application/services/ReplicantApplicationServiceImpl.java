package perso.replicantmicroservice.application.services;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.contracts.mappers.to.entity.CreateReplicantRequestDTOToReplicantMapper;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public class ReplicantApplicationServiceImpl implements ReplicantApplicationService {

	private final CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper;

	@Autowired
	public ReplicantApplicationServiceImpl(CreateReplicantRequestDTOToReplicantMapper createReplicantRequestDTOToReplicantMapper) {
		this.createReplicantRequestDTOToReplicantMapper = createReplicantRequestDTOToReplicantMapper;
	}

	@Override
	public UUID getAndCheckUuid(String id) {
		UUID uuid;
		try {
			uuid = UUID.fromString(id);
		} catch (Exception e) {
			throw e;
		}
		return uuid;
	}

	@Override
	public Replicant mapReplicantRequest(CreateReplicantRequestDTO replicantRequest) {
		try{
			return createReplicantRequestDTOToReplicantMapper.toReplicant(replicantRequest);
		}catch (Exception e){
			throw  e;
		}
	}
}
