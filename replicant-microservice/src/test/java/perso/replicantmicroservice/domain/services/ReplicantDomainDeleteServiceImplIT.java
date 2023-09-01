package perso.replicantmicroservice.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainDeleteService;
import perso.replicantmicroservice.domain.model.Replicant;

@SpringBootTest
class ReplicantDomainDeleteServiceImplIT {

	@BeforeEach
	void beforeEach() {
		replicantRepository.delete();
	}

	@Autowired
	ReplicantRepository replicantRepository;

	@Autowired
	ReplicantDomainDeleteService replicantDomainDeleteService;

	@Autowired
	public ReplicantDomainDeleteServiceImplIT(ReplicantRepository replicantRepository,
	                                          ReplicantDomainDeleteService replicantDomainDeleteService) {
		this.replicantRepository = replicantRepository;
		this.replicantDomainDeleteService = replicantDomainDeleteService;
	}

	@Test
	void deleteByIdentifier(){
		// GIVEN
		Replicant replicant = replicantRepository.create(new Replicant("Albert"));
		assertEquals(1, replicantRepository.read().size());
		// WHEN
		replicantDomainDeleteService.deleteByIdentifier(replicant.getIdentifier().toString());
		// THEN
		assertEquals(0, replicantRepository.read().size());
	}

	@Test
	void deleteAll(){

	}

}