package perso.testmicroservice1.domain.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import perso.testmicroservice1.TestMicroservice1Application;
import perso.testmicroservice1.application.dto.base.ElectricSheepDTO;
import perso.testmicroservice1.application.dto.requests.electricsheep.ElectricSheepRequestDTO;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantRepository;
import perso.testmicroservice1.domain.model.Replicant;

@SpringBootTest(classes = { TestMicroservice1Application.class })
class DomainReplicantServiceIT {

	private ReplicantRepository replicantRepository;
	private DomainReplicantService tested;

	@BeforeEach
	void beforeEach() {
		// Mock the repository and instantiate the service with the mocked repository
		replicantRepository = mock(ReplicantRepository.class);
		tested = new DomainReplicantService(replicantRepository);
	}

	@Test
	@DisplayName("Should created order and save it")
	void createOrderOK() {
		// GIVEN - A product to order
		final ElectricSheepRequestDTO product = new ElectricSheepRequestDTO(UUID.randomUUID(), BigDecimal.TEN, "productName");
		// WHEN - A call to the domain method ONLY
		final UUID id = tested.createReplicant(product);
		// THEN - Verify that the "save" method of the repository has been called by the service
		verify(replicantRepository).save(any(Replicant.class));
		assertNotNull(id);
	}
}
