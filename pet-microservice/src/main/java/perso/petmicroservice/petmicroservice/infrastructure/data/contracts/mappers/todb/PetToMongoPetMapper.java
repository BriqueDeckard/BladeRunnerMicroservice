package perso.petmicroservice.petmicroservice.infrastructure.data.contracts.mappers.todb;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.petmicroservice.petmicroservice.domain.model.Pet;
import perso.petmicroservice.petmicroservice.infrastructure.data.model.MongoPet;

@Mapper
public interface PetToMongoPetMapper {
	@Mapping(target = "identifier", expression = "java(mapId(pet))")
	MongoPet toMongo(Pet pet);

	default String mapId(Pet pet) {
		return pet.getIdentifier() != null ? pet.getIdentifier().toString() : UUID.randomUUID().toString();
	}
}
