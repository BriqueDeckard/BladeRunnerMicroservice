package perso.replicantmicroservice.infrastructure.data.contracts.mappers.todb;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.model.MongoDbReplicant;

@Mapper
public interface MongoDbReplicantToReplicantMapper {
	@Mapping(target = "identifier", expression = "java(mapId(mongoDbReplicant))")
	Replicant toReplicant(MongoDbReplicant mongoDbReplicant);

	default UUID mapId(MongoDbReplicant mongoDbReplicant){
		return UUID.fromString(mongoDbReplicant.getIdentifier());
	}
}
