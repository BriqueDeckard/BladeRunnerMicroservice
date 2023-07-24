package perso.replicantmicroservice.domain.contracts.mappers.to.entity;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.model.Replicant;

@Mapper
public interface CreateReplicantRequestDTOToReplicantMapper {

	@Mapping(target = "identifier", expression = "java(mapId())")
	Replicant toReplicant(CreateReplicantRequestDTO createReplicantRequestDTO);

	default UUID mapId(){
		return UUID.randomUUID();
	}
}
