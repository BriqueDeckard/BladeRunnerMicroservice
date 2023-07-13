package perso.testmicroservice1.domain.services;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import perso.testmicroservice1.application.dto.requests.electricsheep.CreateElectricSheepRequestDTO;
import perso.testmicroservice1.application.dto.response.electricsheep.CreateElectricSheepResponseDTO;
import perso.testmicroservice1.domain.contracts.mappers.to.dto.UUIDToCreateElectricSheepResponseDTOMapper;
import perso.testmicroservice1.domain.contracts.mappers.to.entity.CreateElectricSheepRequestDtoToElectricSheepMapper;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepRepository;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepService;
import perso.testmicroservice1.domain.model.ElectricSheep;

public class DomainElectricSheepService implements ElectricSheepService {

	private final ElectricSheepRepository electricSheepRepository;
	@Autowired
	private CreateElectricSheepRequestDtoToElectricSheepMapper createElectricSheepRequestDtoToElectricSheepMapper;
	@Autowired
	private UUIDToCreateElectricSheepResponseDTOMapper uuidToCreateElectricSheepResponseDTOMapper;

	public DomainElectricSheepService(ElectricSheepRepository electricSheepRepository) {
		this.electricSheepRepository = electricSheepRepository;
	}

	@Override
	public CreateElectricSheepResponseDTO createElectricSheep(CreateElectricSheepRequestDTO productRequest) {
		ElectricSheep electricSheep = createElectricSheepRequestDtoToElectricSheepMapper.toProduct(productRequest);
		 electricSheepRepository.save(electricSheep);
		return uuidToCreateElectricSheepResponseDTOMapper.toDto(electricSheep.getId());
	}

	@Override
	public void deleteElectricSheep(UUID electricSheepId) {

		electricSheepRepository.delete(electricSheepId);
	}
}
