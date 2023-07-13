package perso.testmicroservice1.domain.contracts.mappers.to.dto;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.testmicroservice1.application.dto.response.electricsheep.CreateElectricSheepResponseDTO;

@Mapper
public interface UUIDToCreateElectricSheepResponseDTOMapper {

	@Mapping(target = "id", expression ="java(id)")
	CreateElectricSheepResponseDTO toDto(UUID id);
}
