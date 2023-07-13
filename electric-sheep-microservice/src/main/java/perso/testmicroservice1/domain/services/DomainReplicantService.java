package perso.testmicroservice1.domain.services;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import perso.testmicroservice1.application.dto.base.ElectricSheepDTO;
import perso.testmicroservice1.application.dto.requests.electricsheep.ElectricSheepRequestDTO;
import perso.testmicroservice1.domain.contracts.mappers.to.entity.CreateReplicantRequestDtoToReplicantMapper;
import perso.testmicroservice1.domain.contracts.mappers.to.entity.ElectricSheepRequestToReplicantMapper;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantRepository;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantService;
import perso.testmicroservice1.domain.model.ElectricSheep;
import perso.testmicroservice1.domain.model.Replicant;

/**
 * this service is an adapter that implements the port.
 * Additionally, we'll not register it as a Spring bean because,
 * from a domain perspective, this is in the inside part,
 * and Spring configuration is on the outside.
 */
public class DomainReplicantService implements ReplicantService {

	private final ReplicantRepository replicantRepository;
	@Autowired
	private ElectricSheepRequestToReplicantMapper electricSheepRequestToReplicantMapper;

	public DomainReplicantService(ReplicantRepository replicantRepository) {
		this.replicantRepository = replicantRepository;
	}

	@Override
	public UUID createReplicant(ElectricSheepRequestDTO electricSheepRequest) {
		Replicant replicant = electricSheepRequestToReplicantMapper.toReplicant(electricSheepRequest);
		replicantRepository.save(replicant);
		return replicant.getId();
	}

	@Override
	public void addElectricSheep(UUID id, ElectricSheepDTO productRequest) {
		Replicant order = getReplicant(id);
		// TODO : impl mapstruct
		ElectricSheep electricSheep = new ElectricSheep(productRequest.getId(), productRequest.getPrice(), productRequest.getName());
		order.addOrder(electricSheep);
		replicantRepository.save(order);
	}

	@Override
	public void freeReplicant(UUID id) {
		Replicant order = getReplicant(id);
		order.complete();
		replicantRepository.save(order);
	}

	@Override
	public void deleteElectricSheep(UUID id, UUID electricSheepId) {
		Replicant order = getReplicant(id);
		order.removeReplicant(electricSheepId);

		replicantRepository.save(order);
	}

	private Replicant getReplicant(UUID id) {
		return replicantRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
