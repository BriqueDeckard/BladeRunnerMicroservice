package perso.petmicroservice.petmicroservice.domain.services;

import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perso.petmicroservice.petmicroservice.application.dto.requests.CreatePetRequestDTO;
import perso.petmicroservice.petmicroservice.application.dto.requests.UpdatePetRequestDTO;
import perso.petmicroservice.petmicroservice.domain.contracts.repositories.PetRepository;
import perso.petmicroservice.petmicroservice.domain.contracts.services.PetDomainService;
import perso.petmicroservice.petmicroservice.domain.enums.PetStatus;
import perso.petmicroservice.petmicroservice.domain.model.Pet;

@Service
public class PetDomainServiceImpl implements PetDomainService {

	final PetRepository petRepository;

	@Autowired
	public PetDomainServiceImpl(
			PetRepository petRepository
	) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.create(pet);
	}

	@Override
	public void deleteAll() {
		petRepository.delete();
	}

	@Override
	public void deleteByIdentifier(String identifier) {
		UUID uid;
		try {
			uid = UUID.fromString(identifier);
		} catch (Exception e) {
			throw e;
		}
		petRepository.delete(uid);
	}

	@Override
	public Set<Pet> findAll() {
		return Set.of(new Pet(UUID.randomUUID(), "Pet", 12, PetStatus.CREATED));
	}

	@Override
	public Pet create(CreatePetRequestDTO replicantRequest) {
		return null;
	}

	@Override
	public Pet findByIdentifier(String identifier) {
		return null;
	}

	@Override
	public Pet updateByIdentifier(String identifier, UpdatePetRequestDTO replicantRequest) {
		return null;
	}
}
