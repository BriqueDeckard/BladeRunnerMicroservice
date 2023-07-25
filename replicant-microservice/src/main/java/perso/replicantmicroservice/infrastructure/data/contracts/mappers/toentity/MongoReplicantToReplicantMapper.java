package perso.replicantmicroservice.infrastructure.data.contracts.mappers.toentity;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.model.MongoReplicant;

@Mapper
public interface MongoReplicantToReplicantMapper {
	@Mapping(target = "identifier", expression = "java(mapId(mongoReplicant))")
	Replicant toReplicant(MongoReplicant mongoReplicant);

	default UUID mapId(MongoReplicant mongoReplicant){
		return UUID.fromString(mongoReplicant.getIdentifier());
	}
}
