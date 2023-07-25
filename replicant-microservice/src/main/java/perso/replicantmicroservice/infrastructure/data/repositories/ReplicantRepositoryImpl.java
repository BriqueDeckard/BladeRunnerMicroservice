package perso.replicantmicroservice.infrastructure.data.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.contracts.mappers.toentity.MongoReplicantToReplicantMapper;
import perso.replicantmicroservice.infrastructure.data.contracts.mappers.todb.ReplicantToMongoReplicantMapper;
import perso.replicantmicroservice.infrastructure.data.model.MongoReplicant;

@Repository
public class ReplicantRepositoryImpl implements ReplicantRepository {

	private final MongoReplicantRepository mongoReplicantRepository;

	private final ReplicantToMongoReplicantMapper replicantToMongoReplicantMapper;

	private final MongoReplicantToReplicantMapper mongoReplicantToReplicantMapper;

	@Autowired
	public ReplicantRepositoryImpl(
			MongoReplicantRepository mongoReplicantRepository,
			ReplicantToMongoReplicantMapper replicantToMongoReplicantMapper,
			MongoReplicantToReplicantMapper mongoReplicantToReplicantMapper) {
		this.mongoReplicantRepository = mongoReplicantRepository;
		this.replicantToMongoReplicantMapper = replicantToMongoReplicantMapper;
		this.mongoReplicantToReplicantMapper = mongoReplicantToReplicantMapper;
	}

	@Override
	public Replicant save(Replicant replicant) {
		MongoReplicant mongoReplicant = replicantToMongoReplicantMapper.toMongo(replicant);
		mongoReplicantRepository.save(mongoReplicant);
		return replicant;
	}

	@Override
	public void deleteAll() {
		mongoReplicantRepository.deleteAll();
	}

	@Override
	public Set<Replicant> findAll() {
		List<MongoReplicant> dbReplicants = mongoReplicantRepository.findAll();
		return dbReplicants
				.stream()
				.map(mongoReplicantToReplicantMapper::toReplicant)
				.collect(Collectors.toSet());
	}

	@Override
	public Replicant findByIdentifier(UUID identifier) {
		Optional<MongoReplicant> oReplicant = mongoReplicantRepository.findByIdentifierLike(identifier.toString());
		if (!oReplicant.isPresent()) {
			throw new IllegalStateException("Replicant not found");
		}
		return mongoReplicantToReplicantMapper.toReplicant(oReplicant.get());
	}

	@Override
	public void deleteByIdentifier(String identifier) {
		mongoReplicantRepository.deleteByIdentifierLike(identifier);
	}

	@Override
	public Replicant update(Replicant replicant) {

		MongoReplicant mongoReplicant = replicantToMongoReplicantMapper.toMongo(replicant);
		mongoReplicantRepository.save(mongoReplicant);
		return replicant;
	}
}
