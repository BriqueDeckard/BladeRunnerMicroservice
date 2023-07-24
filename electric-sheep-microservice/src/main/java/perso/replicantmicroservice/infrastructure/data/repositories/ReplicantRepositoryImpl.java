package perso.replicantmicroservice.infrastructure.data.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.contracts.mappers.todb.MongoDbReplicantToReplicantMapper;
import perso.replicantmicroservice.infrastructure.data.contracts.mappers.todb.ReplicantToMongoDbReplicantMapper;
import perso.replicantmicroservice.infrastructure.data.model.MongoDbReplicant;

@Repository
public class ReplicantRepositoryImpl implements ReplicantRepository {

	@Autowired
	MongoReplicantRepository mongoReplicantRepository;

	@Autowired
	ReplicantToMongoDbReplicantMapper replicantToMongoDbReplicantMapper;

	@Autowired
	MongoDbReplicantToReplicantMapper mongoDbReplicantToReplicantMapper;

	@Override
	public Replicant save(Replicant replicant) {
		MongoDbReplicant mongoReplicant = replicantToMongoDbReplicantMapper.toMongoDb(replicant);
		mongoReplicantRepository.save(mongoReplicant);
		return replicant;
	}

	@Override
	public void deleteAll() {
		mongoReplicantRepository.deleteAll();
	}

	@Override
	public Set<Replicant> findAll() {
		List<MongoDbReplicant> dbReplicants = mongoReplicantRepository.findAll();
		return dbReplicants
				.stream()
				.map(dbEntity -> mongoDbReplicantToReplicantMapper.toReplicant(dbEntity))
				.collect(Collectors.toSet());
	}

	@Override
	public Replicant findByIdentifier(String identifier) {
		Optional<MongoDbReplicant> oReplicant = mongoReplicantRepository.findByIdentifierLike(identifier);
		if (!oReplicant.isPresent()) {
			throw new IllegalStateException("Replicant not found");
		}
		Replicant replicant = mongoDbReplicantToReplicantMapper.toReplicant(oReplicant.get());
		return replicant;
	}

	@Override
	public void deleteByIdentifier(String identifier) {
		mongoReplicantRepository.deleteByIdentifierLike(identifier);
	}

	@Override
	public Replicant update(Replicant replicant) {

		MongoDbReplicant mongoReplicant = replicantToMongoDbReplicantMapper.toMongoDb(replicant);
		mongoReplicantRepository.save(mongoReplicant);
		return replicant;
	}
}
