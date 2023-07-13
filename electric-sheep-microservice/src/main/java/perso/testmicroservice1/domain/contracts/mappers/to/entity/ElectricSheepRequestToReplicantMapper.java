package perso.testmicroservice1.domain.contracts.mappers.to.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import perso.testmicroservice1.application.dto.requests.electricsheep.ElectricSheepRequestDTO;
import perso.testmicroservice1.domain.model.ElectricSheep;
import perso.testmicroservice1.domain.model.Replicant;
import perso.testmicroservice1.domain.model.ReplicantPet;

public interface ElectricSheepRequestToReplicantMapper {

	@Mapping(target = "id", expression = "java(mapId())")
	Replicant toReplicant(ElectricSheepRequestDTO electricSheepRequestDTO);

	default UUID mapId() {
		return UUID.randomUUID();
	}

	@AfterMapping
	default void mapReplicant(@MappingTarget Replicant replicant, @Context ElectricSheepRequestDTO electricSheepRequestDTO) {
		ElectricSheepRequestToElectricSheepMapper electricSheepMapper = Mappers.getMapper(ElectricSheepRequestToElectricSheepMapper.class);
		replicant.setReplicantPets(
				new ArrayList<>(List.of(
						new ReplicantPet(electricSheepMapper.toElectricSheep(electricSheepRequestDTO))
				))
		);
	}

}
