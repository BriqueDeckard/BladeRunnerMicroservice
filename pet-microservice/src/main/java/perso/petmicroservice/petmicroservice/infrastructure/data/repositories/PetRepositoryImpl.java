package perso.petmicroservice.petmicroservice.infrastructure.data.repositories;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perso.petmicroservice.petmicroservice.domain.contracts.repositories.PetRepository;
import perso.petmicroservice.petmicroservice.domain.model.Pet;
import perso.petmicroservice.petmicroservice.infrastructure.data.contracts.mappers.todb.PetToMongoPetMapper;
import perso.petmicroservice.petmicroservice.infrastructure.data.contracts.mappers.toentity.MongoPetToPetMapper;
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
	public Pet create(Pet pet) {
		MongoPet mongoPet = petToMongoPetMapper.toMongo(pet);
		mongoPetRepository.save(mongoPet);
		return pet;
	}

	@Override
	public Collection<Pet> read() {
		return null;
	}

	@Override
	public Pet read(UUID identifier) {
		return null;
	}

	@Override
	public Pet update(Pet entity, UUID identifier) {
		return null;
	}

	@Override
	public void delete(UUID identifier) {

	}

	@Override
	public void delete() {

	}
}
