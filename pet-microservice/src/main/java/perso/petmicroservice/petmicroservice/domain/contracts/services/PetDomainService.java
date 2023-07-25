package perso.petmicroservice.petmicroservice.domain.contracts.services;

import java.util.Set;
import org.springframework.stereotype.Service;
import perso.petmicroservice.petmicroservice.application.dto.requests.CreatePetRequestDTO;
import perso.petmicroservice.petmicroservice.application.dto.requests.UpdatePetRequestDTO;
import perso.petmicroservice.petmicroservice.domain.model.Pet;

@Service
public interface PetDomainService {
	Pet save(Pet replicant);

	void deleteAll();

	void deleteByIdentifier(String identifier);

	Set<Pet> findAll();

	Pet create(CreatePetRequestDTO replicantRequest);

	Pet findByIdentifier(String identifier);

	Pet updateByIdentifier(String identifier, UpdatePetRequestDTO replicantRequest);
}
