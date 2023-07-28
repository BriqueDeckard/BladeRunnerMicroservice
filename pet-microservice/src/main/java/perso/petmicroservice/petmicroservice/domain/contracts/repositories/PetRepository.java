package perso.petmicroservice.petmicroservice.domain.contracts.repositories;

import java.util.Collection;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import perso.library.domain.contracts.repositories.GenericDomainRepository;
import perso.petmicroservice.petmicroservice.domain.model.Pet;

@Repository
public interface PetRepository {
	Pet create(Pet entity);

	Collection<Pet> read();

	Pet read(UUID identifier);

	Pet update(Pet entity, UUID identifier);

	void delete(UUID identifier);

	void delete();
}
