package perso.replicantmicroservice.domain.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perso.replicantmicroservice.application.dto.requests.CreateReplicantRequestDTO;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainReadService;
import perso.replicantmicroservice.domain.model.Replicant;

@SpringBootTest
class ReplicantDomainReadServiceImplIT {

	@BeforeEach
	void beforeEach() {
		replicantRepository.delete();
	}

	@Autowired
	ReplicantRepository replicantRepository;

	@Autowired
	ReplicantDomainReadService replicantDomainReadService;

	@Autowired
	public ReplicantDomainReadServiceImplIT(ReplicantRepository replicantRepository, ReplicantDomainReadService replicantDomainReadService) {
		this.replicantRepository = replicantRepository;
		this.replicantDomainReadService = replicantDomainReadService;
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void findAll() {
		// GIVEN
		replicantRepository.create(new Replicant("Albert"));
		replicantRepository.create(new Replicant("Rick"));

		// WHEN
		Set<Replicant> replicants =  replicantDomainReadService.findAll();
		// THEN
		assertEquals(2, replicants.size());
	}

	@Test
	void findByIdentifier(){
		// GIVEN
		Replicant replicant = replicantRepository.create(new Replicant("Albert"));
		// when
		Replicant actualReplicant = replicantDomainReadService.findByIdentifier(replicant.getIdentifier().toString());
		// Then
		assertAll(
				() -> assertEquals(replicant.getIdentifier(), actualReplicant.getIdentifier()),
				() -> assertEquals(replicant.getAge(), actualReplicant.getAge()),
				() -> assertEquals(replicant.getName(), actualReplicant.getName()),
				() -> assertEquals(replicant.getStatus(), actualReplicant.getStatus())
		);

	}
}