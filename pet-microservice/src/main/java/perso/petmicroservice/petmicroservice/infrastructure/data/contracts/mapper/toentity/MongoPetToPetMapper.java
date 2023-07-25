package perso.petmicroservice.petmicroservice.infrastructure.data.contracts.mapper.toentity;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.petmicroservice.petmicroservice.domain.model.Pet;
import perso.petmicroservice.petmicroservice.infrastructure.data.model.MongoPet;

@Mapper
public interface MongoPetToPetMapper {

	@Mapping(target = "identifier", expression = "java(mapId(mongoPet))")
	Pet toPet(MongoPet mongoPet);

	default UUID mapId(MongoPet mongoPet) {
		return UUID.fromString(mongoPet.getIdentifier());
	}
}
