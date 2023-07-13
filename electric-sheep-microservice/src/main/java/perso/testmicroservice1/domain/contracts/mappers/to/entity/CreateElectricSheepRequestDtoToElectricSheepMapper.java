package perso.testmicroservice1.domain.contracts.mappers.to.entity;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.testmicroservice1.application.dto.requests.electricsheep.CreateElectricSheepRequestDTO;
import perso.testmicroservice1.domain.model.ElectricSheep;

@Mapper
public interface CreateElectricSheepRequestDtoToElectricSheepMapper {
	@Mapping(target = "id", expression = "java(mapId())")
	ElectricSheep toProduct(CreateElectricSheepRequestDTO createElectricSheepRequestDTO);

	default UUID mapId() {
		return UUID.randomUUID();
	}
}
