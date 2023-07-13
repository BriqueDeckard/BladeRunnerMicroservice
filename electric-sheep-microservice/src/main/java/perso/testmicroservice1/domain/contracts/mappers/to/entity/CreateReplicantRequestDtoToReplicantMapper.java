package perso.testmicroservice1.domain.contracts.mappers.to.entity;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.testmicroservice1.application.dto.requests.replicants.CreateReplicantRequestDTO;
import perso.testmicroservice1.domain.model.Replicant;

@Mapper
public interface CreateReplicantRequestDtoToReplicantMapper {
	@Mapping(target = "id", expression = "java(mapId())")
	Replicant toOrder(CreateReplicantRequestDTO createReplicantRequestDTO);

	default UUID mapId() {
		return UUID.randomUUID();
	}
}
