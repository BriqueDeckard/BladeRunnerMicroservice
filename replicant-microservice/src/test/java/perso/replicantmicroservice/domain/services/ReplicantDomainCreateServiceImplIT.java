package perso.replicantmicroservice.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainCreateService;

@SpringBootTest
class ReplicantDomainCreateServiceImplIT {

	@BeforeEach
	void beforeEach() {
		replicantRepository.delete();
	}

	@Autowired
	ReplicantRepository replicantRepository;

	@Autowired
	ReplicantDomainCreateService replicantDomainCreateService;

	/**
	 * TODO: Javadoc
	 */
	@Test
	void save() {
		// GIVEN
		CreateReplicantRequestDTO createReplicantRequestDTO = new CreateReplicantRequestDTO("Rick");
		// WHEN
		replicantDomainCreateService.create(createReplicantRequestDTO);
		// THEN
		var replicants = replicantRepository.read();
		assertEquals(1, replicants.size());
	}

}