package perso.petmicroservice.petmicroservice.infrastructure.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import perso.petmicroservice.petmicroservice.infrastructure.data.model.MongoPet;

public interface MongoPetRepository extends MongoRepository<MongoPet, String> {
}
