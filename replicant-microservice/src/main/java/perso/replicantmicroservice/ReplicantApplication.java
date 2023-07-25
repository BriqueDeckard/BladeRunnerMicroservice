package perso.replicantmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import perso.replicantmicroservice.domain.contracts.services.ReplicantDomainService;

/**
 * Used to bootstrap and launch the Spring application from a Java main method.
 *
 * @author Deqard
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = { "perso.*" }, exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
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
	public void run(String... args) throws Exception {

	}
}
