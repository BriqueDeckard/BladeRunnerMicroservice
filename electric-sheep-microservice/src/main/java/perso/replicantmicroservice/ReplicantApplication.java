package perso.replicantmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainService;
import perso.replicantmicroservice.domain.model.Replicant;
import perso.replicantmicroservice.infrastructure.data.model.MongoDbReplicant;

/**
 * Used to bootstrap and launch the Spring application from a Java main method.
 *
 * @author Deqard
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = { "perso.*" })
public class ReplicantApplication implements CommandLineRunner {

	/**
	 * Entry point of the application
	 *
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReplicantApplication.class, args);
	}


	@Autowired
	private ReplicantDomainService replicantDomainService;
	@Override
	public void run(String... args) throws Exception{

	}
}
