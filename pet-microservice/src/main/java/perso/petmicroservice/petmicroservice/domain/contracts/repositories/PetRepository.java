package perso.petmicroservice.petmicroservice.domain.contracts.repositories;

import java.util.UUID;
import perso.library.domain.contracts.repositories.GenericDomainRepository;
import perso.petmicroservice.petmicroservice.domain.model.Pet;

public interface PetRepository extends GenericDomainRepository<Pet, UUID> {
}
