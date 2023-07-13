package perso.testmicroservice1.domain.contracts.mappers.to.entity;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import perso.testmicroservice1.application.dto.requests.electricsheep.ElectricSheepRequestDTO;
import perso.testmicroservice1.domain.model.ElectricSheep;

@Mapper
public interface ElectricSheepRequestToElectricSheepMapper {

	@Mapping(target = "id", expression = "java(mapId())")
	ElectricSheep toElectricSheep(ElectricSheepRequestDTO electricSheepRequestDTO);

	default UUID mapId(){
		return UUID.randomUUID();
	}
}
