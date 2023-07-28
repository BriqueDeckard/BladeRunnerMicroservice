package perso.replicantmicroservice.infrastructure.data.repositories;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perso.replicantmicroservice.domain.contracts.repositories.ReplicantRepository;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.model.MongoReplicant;

@SpringBootTest
class ReplicantRepositoryImplTest {
	MongoReplicantRepository mongoReplicantRepository;
	private final ReplicantRepository replicantRepository;

	@Autowired
	public ReplicantRepositoryImplTest(ReplicantRepository replicantRepository) {
		this.replicantRepository = replicantRepository;
	}

	@BeforeEach
	void setUp() {
		this.mongoReplicantRepository = Mockito.mock(MongoReplicantRepository.class);
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void create() {
		// GIVEN
		Replicant replicant = new Replicant("Bruce");
		// WHEN
		replicantRepository.create(replicant);
		// THEN
		verify(this.mongoReplicantRepository)
				.insert((MongoReplicant) Mockito.any());
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void read() {
		// GIVEN
		// WHEN
		// THEN
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void testRead() {
		// GIVEN
		// WHEN
		// THEN
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void update() {
		// GIVEN
		// WHEN
		// THEN
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void delete() {
		// GIVEN
		// WHEN
		// THEN
	}

	/**
	 * TODO: Javadoc
	 */
	@Test
	void testDelete() {
		// GIVEN
		// WHEN
		// THEN
	}
}