package perso.replicantmicroservice.infrastructure.data.repositories;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.contracts.mappers.todb.ReplicantToMongoReplicantMapper;
import perso.replicantmicroservice.infrastructure.data.contracts.mappers.toentity.MongoReplicantToReplicantMapper;
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
	public Replicant create(Replicant replicant) {
		MongoReplicant mongoReplicant = replicantToMongoReplicantMapper.toMongo(replicant);
		mongoReplicantRepository.insert(mongoReplicant);
		replicant.setIdentifier(UUID.fromString(mongoReplicant.getIdentifier()));
		return replicant;
	}

	@Override
	public Set<Replicant> read() {
		return mongoReplicantRepository
				.findAll()
				.stream()
				.map(mongoReplicantToReplicantMapper::toReplicant)
				.collect(Collectors.toSet());
	}

	@Override
	public Replicant read(UUID uuid) {
		return mongoReplicantToReplicantMapper.toReplicant(
				mongoReplicantRepository
						.findById(uuid.toString())
						.orElseThrow(IllegalArgumentException::new));
	}

	@Override
	public Replicant update(Replicant replicant, UUID uuid) {
		MongoReplicant mongoReplicant = replicantToMongoReplicantMapper.toMongo(replicant, uuid);
		mongoReplicantRepository.save(mongoReplicant);
		return mongoReplicantToReplicantMapper.toReplicant(mongoReplicant);
	}

	@Override
	public void delete(UUID uuid) {
		mongoReplicantRepository.deleteById(uuid.toString());
	}

	@Override
	public void delete() {
		mongoReplicantRepository.deleteAll();
	}
}
