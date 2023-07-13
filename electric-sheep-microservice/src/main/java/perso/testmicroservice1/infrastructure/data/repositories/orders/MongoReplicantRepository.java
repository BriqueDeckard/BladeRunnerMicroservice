package perso.testmicroservice1.infrastructure.data.repositories.orders;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantRepository;
import perso.testmicroservice1.domain.model.Replicant;

@Component
public class MongoReplicantRepository implements ReplicantRepository {
	private final SpringDataMongoReplicantRepository replicantRepository;

	@Autowired
	public MongoReplicantRepository(SpringDataMongoReplicantRepository replicantRepository) {
		this.replicantRepository = replicantRepository;
	}

	@Override
	public Optional<Replicant> findById(UUID id) {
		return replicantRepository.findById(id);
	}

	@Override
	public void save(Replicant replicant) {
		replicantRepository.save(replicant);
	}
}
