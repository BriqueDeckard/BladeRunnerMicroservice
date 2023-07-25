package perso.replicantmicroservice.domain.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainService;
import perso.replicantmicroservice.domain.model.Replicant;

@SpringBootTest
class ReplicantDomainServiceImplIT {

	@BeforeEach
	void beforeEach(){
		replicantRepository.deleteAll();
	}

	@Autowired
	ReplicantRepository replicantRepository;

	@Autowired
	ReplicantDomainService replicantDomainService;

	/**
	 * TODO: Javadoc
	 */
	@Test
	void save() {
		// GIVEN
		Replicant replicant = new Replicant("Rick");
		// WHEN
		replicantDomainService.save(replicant);
		// THEN
		Set<Replicant> replicants =  replicantRepository.findAll();
		assertEquals(1, replicants.size());
	}
}