package perso.replicantmicroservice.infrastructure.data.contracts.mappers.todb;

import java.util.UUID;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.model.MongoReplicant;

@Mapper
public interface ReplicantToMongoReplicantMapper {
	@Mapping(target = "identifier", expression = "java(mapId(replicant))")
	MongoReplicant toMongo(Replicant replicant);
	@Mapping(target = "identifier", expression = "java(id.toString())")
	MongoReplicant toMongo(Replicant replicant, @Context UUID id);

	default String mapId(Replicant replicant) {
		if (replicant.getIdentifier() != null) {
			return replicant.getIdentifier().toString();
		} else return UUID.randomUUID().toString();
	}
}
