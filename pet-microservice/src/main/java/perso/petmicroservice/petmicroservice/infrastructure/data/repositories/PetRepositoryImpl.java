package perso.petmicroservice.petmicroservice.infrastructure.data.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perso.petmicroservice.petmicroservice.domain.contracts.repositories.PetRepository;
import perso.petmicroservice.petmicroservice.domain.model.Pet;
import perso.petmicroservice.petmicroservice.infrastructure.data.contracts.mapper.todb.PetToMongoPetMapper;
import perso.petmicroservice.petmicroservice.infrastructure.data.contracts.mapper.toentity.MongoPetToPetMapper;
import perso.petmicroservice.petmicroservice.infrastructure.data.model.MongoPet;

@Repository
public class PetRepositoryImpl implements PetRepository {
	private final MongoPetRepository mongoPetRepository;
	private final PetToMongoPetMapper petToMongoPetMapper;
	private final MongoPetToPetMapper mongoPetToPetMapper;


	@Autowired
	public PetRepositoryImpl(
			MongoPetRepository mongoPetRepository,
			PetToMongoPetMapper petToMongoPetMapper,
			MongoPetToPetMapper mongoPetToPetMapper) {
		this.mongoPetRepository = mongoPetRepository;
		this.petToMongoPetMapper = petToMongoPetMapper;
		this.mongoPetToPetMapper = mongoPetToPetMapper;
	}

	@Override
	public Pet save(Pet pet) {
		MongoPet mongoPet = petToMongoPetMapper.toMongo(pet);
		mongoPetRepository.save(mongoPet);
		return pet;
	}
	@Override
	public void deleteAll() {
		mongoPetRepository.deleteAll();

	}
	@Override
	public Set<Pet> findAll() {
		List<MongoPet> mongoPets = mongoPetRepository.findAll();
		return mongoPets
				.stream()
				.map(mongoPetToPetMapper::toPet)
				.collect(Collectors.toSet());
	}

	@Override
	public Pet findByIdentifier(UUID identifier) {
		Optional<MongoPet> oPet = mongoPetRepository.findByIdentifierLike(identifier.toString());
		if (!oPet.isPresent()) {
			throw new IllegalStateException("Replicant not found");
		}
		return mongoPetToPetMapper.toPet(oPet.get());
	}

	@Override
	public void deleteByIdentifier(String identifier) {
		mongoPetRepository.deleteByIdentifierLike(identifier);
	}
}
